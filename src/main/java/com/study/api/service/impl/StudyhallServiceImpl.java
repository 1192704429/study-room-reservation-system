package com.study.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.dao.StudyhallDao;
import com.study.api.dto.StudyhallDTO;
import com.study.api.service.StudyhallService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 自习室管理业务层实现类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Service("studyhallService")
public class StudyhallServiceImpl extends ServiceImpl<StudyhallDao, StudyhallDTO> implements StudyhallService {

    @Override
    public Page<StudyhallDTO> basePage(StudyhallDTO studyhallDTO) {
        if (null != studyhallDTO.getCurrent() && null != studyhallDTO.getPageSize())
            studyhallDTO.setCurrent((studyhallDTO.getCurrent() - 1) * studyhallDTO.getPageSize());
        List<StudyhallDTO> list = this.baseMapper.findList(studyhallDTO);
        int count = this.baseMapper.findPageCount(studyhallDTO);
        Page<StudyhallDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<StudyhallDTO> findList(StudyhallDTO studyhallDTO) {
        return this.baseMapper.findList(studyhallDTO);
    }

}
