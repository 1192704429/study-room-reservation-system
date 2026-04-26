package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.StudyhallDTO;
import java.util.List;
/**
* @description: 自习室管理业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface StudyhallService extends IService<StudyhallDTO> {

    /**
    * 默认分页方法
    * @param studyhallDTO
    * @return
    */
    Page<StudyhallDTO> basePage(StudyhallDTO studyhallDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param studyhallDTO
    * @return
    */
    List<StudyhallDTO> findList(StudyhallDTO studyhallDTO);

}
