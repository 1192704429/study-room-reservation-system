package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.SubscribeDTO;
import java.util.List;
/**
* @description: 预约管理业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface SubscribeService extends IService<SubscribeDTO> {

    /**
    * 默认分页方法
    * @param subscribeDTO
    * @return
    */
    Page<SubscribeDTO> basePage(SubscribeDTO subscribeDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param subscribeDTO
    * @return
    */
    List<SubscribeDTO> findList(SubscribeDTO subscribeDTO);

}
