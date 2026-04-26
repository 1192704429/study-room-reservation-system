package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.SeatDTO;
import java.util.List;
/**
* @description: 座位管理业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface SeatService extends IService<SeatDTO> {

    /**
    * 默认分页方法
    * @param seatDTO
    * @return
    */
    Page<SeatDTO> basePage(SeatDTO seatDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param seatDTO
    * @return
    */
    List<SeatDTO> findList(SeatDTO seatDTO);

    String getQrcode(Long seatId) throws Exception;
}
