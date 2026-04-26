package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.StudyhallDTO;
import com.study.api.service.StudyhallService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.study.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.study.api.service.TypesService;
import com.study.api.dto.TypesDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 自习室管理对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/studyhall")
public class StudyhallController extends BaseController<StudyhallService, StudyhallDTO> {

    @Autowired
    private TypesService typesService;

    @Override
    @Resource(name = "studyhallService")
    protected void setBaseService(StudyhallService studyhallService) {
        this.baseService = studyhallService;
    }

    /**
    * 默认分页查询
    * @param studyhallDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody StudyhallDTO studyhallDTO) {
        return ReturnMsg.ok(baseService.basePage(studyhallDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param studyhallDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody StudyhallDTO studyhallDTO) {
        return ReturnMsg.ok(baseService.findList(studyhallDTO));
    }

    @Override
    protected void beforeSave(StudyhallDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/types")
    public ReturnMsg allTypes() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<TypesDTO> dtos = typesService.list();
            for (TypesDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTypeName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

