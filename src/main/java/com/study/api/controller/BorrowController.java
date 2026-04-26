package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.BorrowDTO;
import com.study.api.service.BorrowService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.study.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.study.api.service.StudentService;
import com.study.api.dto.StudentDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 借还管理对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/borrow")
public class BorrowController extends BaseController<BorrowService, BorrowDTO> {

    @Autowired
    private StudentService studentService;

    @Override
    @Resource(name = "borrowService")
    protected void setBaseService(BorrowService borrowService) {
        this.baseService = borrowService;
    }

    /**
    * 默认分页查询
    * @param borrowDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BorrowDTO borrowDTO) {
        return ReturnMsg.ok(baseService.basePage(borrowDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param borrowDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BorrowDTO borrowDTO) {
        return ReturnMsg.ok(baseService.findList(borrowDTO));
    }

    @Override
    protected void beforeSave(BorrowDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/student")
    public ReturnMsg allStudent() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<StudentDTO> dtos = studentService.list();
            for (StudentDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getStuName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

