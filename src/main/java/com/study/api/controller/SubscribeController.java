package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.SubscribeDTO;
import com.study.api.service.SubscribeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.study.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.study.api.service.StudentService;
import com.study.api.dto.StudentDTO;
import com.study.api.service.StudyhallService;
import com.study.api.dto.StudyhallDTO;
import com.study.api.service.SeatService;
import com.study.api.dto.SeatDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.study.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 预约管理对外接口层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@RestController
@RequestMapping("/subscribe")
public class SubscribeController extends BaseController<SubscribeService, SubscribeDTO> {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudyhallService studyhallService;
    @Autowired
    private SeatService seatService;

    @Override
    @Resource(name = "subscribeService")
    protected void setBaseService(SubscribeService subscribeService) {
        this.baseService = subscribeService;
    }

    /**
    * 默认分页查询
    * @param subscribeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SubscribeDTO subscribeDTO) {
        return ReturnMsg.ok(baseService.basePage(subscribeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param subscribeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SubscribeDTO subscribeDTO) {
        return ReturnMsg.ok(baseService.findList(subscribeDTO));
    }

    @Override
    protected void beforeSave(SubscribeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/student")
    public ReturnMsg allStudent() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<StudentDTO> dtos = studentService.list();
            for (StudentDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getStuName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
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

    @GetMapping("/all/seat")
    public ReturnMsg allSeat() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<SeatDTO> dtos = seatService.list();
            for (SeatDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNumber());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

