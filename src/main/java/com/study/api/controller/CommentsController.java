package com.study.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.api.common.BaseController;
import com.study.api.common.ReturnMsg;
import com.study.api.dto.CommentsDTO;
import com.study.api.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 贴吧信息管理对外接口层
 * @author: xyl
 * @create: 2025.03.11 10:41:10
 */
@RestController
@RequestMapping("/comments")
public class CommentsController extends BaseController<CommentsService, CommentsDTO> {


    @Override
    @Resource(name = "commentsService")
    protected void setBaseService(CommentsService commentsService) {
        this.baseService = commentsService;
    }

    /**
     * 默认分页查询
     *
     * @param commentsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody CommentsDTO commentsDTO) {
        commentsDTO.setIsOrder("true");
        commentsDTO.setParentId(0L);
        Page<CommentsDTO> dtoPage = baseService.basePage(commentsDTO);
        if (CollectionUtil.isNotEmpty(dtoPage.getRecords())) {
            for (CommentsDTO dto : dtoPage.getRecords()) {
                CommentsDTO query = new CommentsDTO();
                query.setParentId(dto.getId());
                List<CommentsDTO> list = this.baseService.findList(query);
                dto.setChildren(list);
            }
        }
        return ReturnMsg.ok(dtoPage);
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param commentsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody CommentsDTO commentsDTO) {
        return ReturnMsg.ok(baseService.findList(commentsDTO));
    }

    @Override
    protected void beforeSave(CommentsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/allComments")
    public ReturnMsg allComments(@RequestBody CommentsDTO commentsDTO) {
        commentsDTO.setIsOrder("true");
        List<CommentsDTO> baseServiceList = baseService.findList(commentsDTO);
        if (CollectionUtil.isNotEmpty(baseServiceList)) {
            for (CommentsDTO dto : baseServiceList) {
                CommentsDTO query = new CommentsDTO();
                query.setParentId(dto.getId());
                dto.setCommentsDTOS(this.baseService.findList(query));
            }
        }
        return ReturnMsg.ok(baseServiceList);
    }


}

