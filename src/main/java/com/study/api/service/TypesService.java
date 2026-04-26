package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.TypesDTO;
import java.util.List;
/**
* @description: 自习室分类业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface TypesService extends IService<TypesDTO> {

    /**
    * 默认分页方法
    * @param typesDTO
    * @return
    */
    Page<TypesDTO> basePage(TypesDTO typesDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param typesDTO
    * @return
    */
    List<TypesDTO> findList(TypesDTO typesDTO);

}
