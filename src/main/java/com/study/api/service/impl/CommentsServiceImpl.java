package com.study.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.dao.CommentsDao;
import com.study.api.dto.CommentsDTO;
import com.study.api.service.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 贴吧信息管理业务层实现类
* @author: xyl
* @create: 2025.03.11 10:41:10
*/
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsDTO> implements CommentsService {

    @Override
    public Page<CommentsDTO> basePage(CommentsDTO commentsDTO) {
        if (null != commentsDTO.getCurrent() && null != commentsDTO.getPageSize())
            commentsDTO.setCurrent((commentsDTO.getCurrent() - 1) * commentsDTO.getPageSize());
        List<CommentsDTO> list = this.baseMapper.findList(commentsDTO);
        int count = this.baseMapper.findPageCount(commentsDTO);
        Page<CommentsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<CommentsDTO> findList(CommentsDTO commentsDTO) {
        return this.baseMapper.findList(commentsDTO);
    }

}
