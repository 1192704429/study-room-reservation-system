package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.BorrowDTO;
import java.util.List;
/**
* @description: 借还管理业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface BorrowService extends IService<BorrowDTO> {

    /**
    * 默认分页方法
    * @param borrowDTO
    * @return
    */
    Page<BorrowDTO> basePage(BorrowDTO borrowDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param borrowDTO
    * @return
    */
    List<BorrowDTO> findList(BorrowDTO borrowDTO);

}
