package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.CommentsDTO;

import java.util.List;

/**
* @description: 贴吧信息管理业务层接口
* @author: xyl
* @create: 2025.03.11 10:41:10
*/
public interface CommentsService extends IService<CommentsDTO> {

    /**
    * 默认分页方法
    * @param commentsDTO
    * @return
    */
    Page<CommentsDTO> basePage(CommentsDTO commentsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param commentsDTO
    * @return
    */
    List<CommentsDTO> findList(CommentsDTO commentsDTO);

}
