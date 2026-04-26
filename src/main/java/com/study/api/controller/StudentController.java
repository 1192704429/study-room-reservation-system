package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.StudentDTO;
import com.study.api.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
/**
* @description: 学生表对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<StudentService, StudentDTO> {


    @Override
    @Resource(name = "studentService")
    protected void setBaseService(StudentService studentService) {
        this.baseService = studentService;
    }

    /**
    * 默认分页查询
    * @param studentDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody StudentDTO studentDTO) {
        return ReturnMsg.ok(baseService.basePage(studentDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param studentDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody StudentDTO studentDTO) {
        return ReturnMsg.ok(baseService.findList(studentDTO));
    }


    @PostMapping(value = "/login")
    public ReturnMsg login(@RequestBody StudentDTO usersDTO) throws Exception {
        List<StudentDTO> usersDTOS = baseService.findList(usersDTO);
        if (CollectionUtil.isEmpty(usersDTOS)) throw new Exception("账号或密码有误!");
        StudentDTO studentDTO = usersDTOS.get(0);
        if (studentDTO.getStatus() == 0) return ReturnMsg.error("请等待管理员审核账号!");
        if (studentDTO.getStatus() == 2) return ReturnMsg.error("账户已停用，请联系管理员!");
        return ReturnMsg.ok(studentDTO);
    }

    @PostMapping(value = "/register")
    public ReturnMsg register(@RequestBody StudentDTO usersDTO) throws Exception {
        StudentDTO usersDTO1 = new StudentDTO();
        usersDTO1.setStuPhone(usersDTO.getStuPhone());
        List<StudentDTO> usersDTOS = baseService.findList(usersDTO1);
        if (CollectionUtil.isNotEmpty(usersDTOS)) throw new Exception("当前账号已经注册,不呢重复注册!");
        usersDTO.setStuName("学生" + usersDTO.getStuPhone());
        usersDTO.setStatus(0);
        this.baseService.save(usersDTO);
        return ReturnMsg.ok();
    }


}

