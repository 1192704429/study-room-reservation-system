package com.study.api.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.common.util.WxUtil;
import com.study.api.dao.SeatDao;
import com.study.api.dto.SeatDTO;
import com.study.api.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 座位管理业务层实现类
 * @author: wuming
 * @create: 2025.03.06 13:54:24
 */
@Service("seatService")
public class SeatServiceImpl extends ServiceImpl<SeatDao, SeatDTO> implements SeatService {

    @Override
    public Page<SeatDTO> basePage(SeatDTO seatDTO) {
        if (null != seatDTO.getCurrent() && null != seatDTO.getPageSize())
            seatDTO.setCurrent((seatDTO.getCurrent() - 1) * seatDTO.getPageSize());
        List<SeatDTO> list = this.baseMapper.findList(seatDTO);
        int count = this.baseMapper.findPageCount(seatDTO);
        Page<SeatDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SeatDTO> findList(SeatDTO seatDTO) {
        return this.baseMapper.findList(seatDTO);
    }

    @Autowired
    private WxUtil wxUtil;

    @Override
    public String getQrcode(Long seatId) throws Exception {
        if (seatId == null) return "";
        SeatDTO seatDTO = this.getById(seatId);
        if (seatDTO != null && StrUtil.isNotEmpty(seatDTO.getQrCode())) return seatDTO.getQrCode();
        HashMap<String, Object> params = new HashMap<>(10);
        params.put("env_version", "trial");
        params.put("scene", seatId);
        // 页面路径
        params.put("page", "pages/setDetail/setDetail");
        params.put("check_path", false);
        String shareQrCode = wxUtil.getShareQrCode(params);
        seatDTO.setQrCode(shareQrCode);
        this.updateById(seatDTO);
        return shareQrCode;
    }

}
