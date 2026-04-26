package com.study.api.controller;

import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.NoticeDTO;
import com.study.api.service.NoticeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
* @description: 公告管理对外接口层
* @author: wuming
* @create: 2025.03.03 15:24:23
*/
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController<NoticeService, NoticeDTO> {


    @Override
    @Resource(name = "noticeService")
    protected void setBaseService(NoticeService noticeService) {
        this.baseService = noticeService;
    }

    /**
    * 默认分页查询
    * @param noticeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.basePage(noticeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param noticeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.findList(noticeDTO));
    }

    @Override
    protected void beforeSave(NoticeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

