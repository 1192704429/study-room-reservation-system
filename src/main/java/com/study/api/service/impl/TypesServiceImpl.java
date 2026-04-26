package com.study.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.dao.TypesDao;
import com.study.api.dto.TypesDTO;
import com.study.api.service.TypesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 自习室分类业务层实现类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Service("typesService")
public class TypesServiceImpl extends ServiceImpl<TypesDao, TypesDTO> implements TypesService {

    @Override
    public Page<TypesDTO> basePage(TypesDTO typesDTO) {
        if (null != typesDTO.getCurrent() && null != typesDTO.getPageSize())
            typesDTO.setCurrent((typesDTO.getCurrent() - 1) * typesDTO.getPageSize());
        List<TypesDTO> list = this.baseMapper.findList(typesDTO);
        int count = this.baseMapper.findPageCount(typesDTO);
        Page<TypesDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TypesDTO> findList(TypesDTO typesDTO) {
        return this.baseMapper.findList(typesDTO);
    }

}
