package com.study.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.api.dao.BorrowDao;
import com.study.api.dto.BorrowDTO;
import com.study.api.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 借还管理业务层实现类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Service("borrowService")
public class BorrowServiceImpl extends ServiceImpl<BorrowDao, BorrowDTO> implements BorrowService {

    @Override
    public Page<BorrowDTO> basePage(BorrowDTO borrowDTO) {
        if (null != borrowDTO.getCurrent() && null != borrowDTO.getPageSize())
            borrowDTO.setCurrent((borrowDTO.getCurrent() - 1) * borrowDTO.getPageSize());
        List<BorrowDTO> list = this.baseMapper.findList(borrowDTO);
        int count = this.baseMapper.findPageCount(borrowDTO);
        Page<BorrowDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BorrowDTO> findList(BorrowDTO borrowDTO) {
        return this.baseMapper.findList(borrowDTO);
    }

}
