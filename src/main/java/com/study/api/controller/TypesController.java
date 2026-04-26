package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.TypesDTO;
import com.study.api.service.TypesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 自习室分类对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/types")
public class TypesController extends BaseController<TypesService, TypesDTO> {


    @Override
    @Resource(name = "typesService")
    protected void setBaseService(TypesService typesService) {
        this.baseService = typesService;
    }

    /**
    * 默认分页查询
    * @param typesDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TypesDTO typesDTO) {
        return ReturnMsg.ok(baseService.basePage(typesDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param typesDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TypesDTO typesDTO) {
        return ReturnMsg.ok(baseService.findList(typesDTO));
    }

    @Override
    protected void beforeSave(TypesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

