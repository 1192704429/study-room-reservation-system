package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.ManageDTO;
import com.study.api.service.ManageService;
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
* @description: 管理员表对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/manage")
public class ManageController extends BaseController<ManageService, ManageDTO> {


    @Override
    @Resource(name = "manageService")
    protected void setBaseService(ManageService manageService) {
        this.baseService = manageService;
    }

    /**
    * 默认分页查询
    * @param manageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.basePage(manageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.findList(manageDTO));
    }


}

