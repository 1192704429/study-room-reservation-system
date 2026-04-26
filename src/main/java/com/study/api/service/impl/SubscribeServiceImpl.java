package com.study.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.dao.SubscribeDao;
import com.study.api.dto.SubscribeDTO;
import com.study.api.service.SubscribeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 预约管理业务层实现类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Service("subscribeService")
public class SubscribeServiceImpl extends ServiceImpl<SubscribeDao, SubscribeDTO> implements SubscribeService {

    @Override
    public Page<SubscribeDTO> basePage(SubscribeDTO subscribeDTO) {
        if (null != subscribeDTO.getCurrent() && null != subscribeDTO.getPageSize())
            subscribeDTO.setCurrent((subscribeDTO.getCurrent() - 1) * subscribeDTO.getPageSize());
        List<SubscribeDTO> list = this.baseMapper.findList(subscribeDTO);
        int count = this.baseMapper.findPageCount(subscribeDTO);
        Page<SubscribeDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SubscribeDTO> findList(SubscribeDTO subscribeDTO) {
        return this.baseMapper.findList(subscribeDTO);
    }

}
