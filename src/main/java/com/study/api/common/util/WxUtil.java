package com.study.api.common.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: WxUtil
 * @author: azhou
 * @Create: 2022-06-14 20:14
 */
@Component
@Slf4j
public class WxUtil {

    @Value("${wx.access_token_url}")
    private String accessTokenUrl;

    @Value("${wx.qr_code_url}")
    private String qrCodeUrl;

    @Value("${wx.session_key_url}")
    private String sessionKeyUrl;

    /**
     * 二维码文件存储目录
     */
    private String fileDir = "qrcode/";

    /**
     * 分享二维码临时图片名称
     */
    @Value("${temporary.file.path}")
    private String temporaryFilePath;

    @Value("${new-tomcat.folder}")
    private String newTomcatFolder;

    @Value("${new-tomcat.host}")
    private String newTomcatHost;

    /**
     * 获取分享的二维码
     *
     * @param pageParam 分享页面的参数  包括页面路径 进页面必须的参数等
     * @return
     */
    public String getShareQrCode(Map<String, Object> pageParam) throws Exception {
        String imgPath = "";
        String accessTokenRes = HttpUtil.get(accessTokenUrl);
        if (StrUtil.isEmpty(accessTokenRes)) return imgPath;
        // 解析相应内容（转换成json对象）
        JSONObject json = new JSONObject(accessTokenRes);
        // 拿到accessToken
        String accessToken = (String) json.get("access_token");
        FileOutputStream outputStream = null;
        File file = null;
        // 通过UUID生成唯一文件名
        String filename = UUID.randomUUID() + ".jpg";
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(String.format(qrCodeUrl, accessToken));
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            // 必须是json模式的 post
            String body = JSON.toJSONString(pageParam);
            StringEntity entity = new StringEntity(body);
            entity.setContentType("image/png");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            log.info("resp:{}",response.getEntity().getContent());
            InputStream inputStream = response.getEntity().getContent();
            // 本地临时文件名称
            String tempFileName = temporaryFilePath + UUID.randomUUID().toString().substring(0, 16) + ".jpg";
            // 创建临时文件
            file = new File(tempFileName);
            outputStream = new FileOutputStream(file);
            file.createNewFile();
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            // 读取临时文件
            InputStream asStream = new FileInputStream(tempFileName);
            // 文件上传
            // 指定要保存的图片路径和文件名
            File savePathFile = new File(newTomcatFolder);
            if (!savePathFile.exists()) {
                // 若不存在该目录，则创建目录
                savePathFile.mkdir();
            }
            saveInputStreamToImage(asStream, new File(newTomcatFolder + filename));
        } catch (IOException e) {
            log.error("wx小程序二维码生成失败,页面参数,pageParam:{},accessToken:{}", pageParam, accessToken);
            throw new Exception("wx小程序二维码生成失败");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (file != null) {
                    file.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newTomcatHost + filename;
    }

    private void saveInputStreamToImage(InputStream inputStream, File outputFile) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 根据code获取sessionKey和openid
     *
     * @param code
     * @return map
     */
    public Map<String, Object> sessionKey(String code) {
        Map<String, Object> map = null;
        try {
            map = new HashMap<>(4);
            String res = HttpUtil.get(String.format(sessionKeyUrl, code));
            log.debug("获取wxsessionKey结束，结果：{}", res);
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(res);
            if (jsonObject.containsKey("session_key")) {
                String openid = jsonObject.get("openid").toString();
                String sessionKey = jsonObject.get("session_key").toString();
                map.put("openid", openid);
                map.put("sessionKey", sessionKey);
            }
        } catch (Exception e) {
            log.error("wxCode解密失败：code->{}", code);
            return map;
        }
        return map;
    }

    /**
     * wx解密用户信息
     *
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     */
    public static com.alibaba.fastjson.JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + 1;
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, StandardCharsets.UTF_8);
                return com.alibaba.fastjson.JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            log.error("wx用户信息解密失败,解密参数,encryptedData:{},sessionKey:{},iv:{}\n错误信息:{}", encryptedData, sessionKey, iv, e.getMessage());
        }
        return null;
    }

}
