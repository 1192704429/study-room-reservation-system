package com.study.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.SeatDTO;
import com.study.api.dto.SubscribeDTO;
import com.study.api.service.SeatService;
import com.study.api.service.SubscribeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.study.api.common.BaseSelectEntity;

import java.util.ArrayList;

import com.study.api.service.StudyhallService;
import com.study.api.dto.StudyhallDTO;

import javax.annotation.Resource;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;

import java.util.Date;

/**
 * @description: 座位管理对外接口层
 * @author: wuming
 * @create: 2025.03.06 13:54:24
 */
@RestController
@RequestMapping("/seat")
public class SeatController extends BaseController<SeatService, SeatDTO> {

    @Autowired
    private StudyhallService studyhallService;

    @Override
    @Resource(name = "seatService")
    protected void setBaseService(SeatService seatService) {
        this.baseService = seatService;
    }

    /**
     * 默认分页查询
     *
     * @param seatDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SeatDTO seatDTO) {
        return ReturnMsg.ok(baseService.basePage(seatDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param seatDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SeatDTO seatDTO) {
        return ReturnMsg.ok(baseService.findList(seatDTO));
    }


    @GetMapping("/qrcode/{orderId}")
    public ReturnMsg getQrcode(@PathVariable("orderId") Long orderId) throws Exception {
        String url = baseService.getQrcode(orderId);
        return ReturnMsg.ok(url);
    }

    @Override
    protected void beforeSave(SeatDTO entity) throws Exception {
        // 增加自习室里面的座位数量
        Long hallId = entity.getHallId();
        StudyhallDTO service = studyhallService.getById(hallId);
        if (service != null) {
            Integer num = service.getNum();
            Integer currentNum = service.getCurrentNum();
            num++;
            currentNum++;
            service.setNum(num);
            service.setCurrentNum(currentNum);
            studyhallService.updateById(service);
        }
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }


    @Autowired
    private SubscribeService subscribeService;

    @GetMapping("/qiandao/{id}")
    public ReturnMsg qiandao(@PathVariable("id") Long id) throws Exception {
        LambdaQueryWrapper<SubscribeDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SubscribeDTO::getSeatId, id).eq(SubscribeDTO::getStatus, 0).last("limit 1");
        SubscribeDTO subscribeDTO = subscribeService.getOne(queryWrapper);
        if (subscribeDTO == null) throw new Exception("预约不存在！");
        subscribeDTO.setStatus(1);
        subscribeService.updateById(subscribeDTO);
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setId(id);
        seatDTO.setStatus(2);
        this.baseService.updateById(seatDTO);
        return ReturnMsg.ok();
    }


    @PostMapping(value = "/updateStatus")
    public ReturnMsg updateStatus(@RequestBody SeatDTO seatDTO) {
        SeatDTO seat = baseService.getById(seatDTO.getId());
        Long hallId = seat.getHallId();
        StudyhallDTO service = studyhallService.getById(hallId);
        if (service != null) {
            Integer currentNum = service.getCurrentNum();
            if (seatDTO.getStatus() == 0) {
                currentNum++;
                service.setCurrentNum(currentNum);
            }
            if (seatDTO.getStatus() == 1) {
                currentNum--;
                service.setCurrentNum(currentNum);
            }
            if (seatDTO.getStatus() == 3) {
                currentNum--;
                service.setCurrentNum(currentNum);
            }
            studyhallService.updateById(service);
        }
        baseService.updateById(seatDTO);
        return ReturnMsg.ok();
    }

    @Override
    protected void beforeRemoveByIds(List<Long> idList) throws Exception {
        for (Long id : idList) {
            SeatDTO seat = baseService.getById(id);
            Long hallId = seat.getHallId();
            StudyhallDTO service = studyhallService.getById(hallId);
            if (service != null) {
                Integer num = service.getNum();
                Integer currentNum = service.getCurrentNum();
                num--;
                currentNum--;
                service.setNum(num <= 0 ? 0 : num);
                service.setCurrentNum(currentNum <= 0 ? 0 : currentNum);
                studyhallService.updateById(service);
            }
        }
        super.beforeRemoveByIds(idList);
    }

    @GetMapping("/all/studyhall")
    public ReturnMsg allStudyhall() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<StudyhallDTO> dtos = studyhallService.list();
        for (StudyhallDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

