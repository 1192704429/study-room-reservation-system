package com.study.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.api.dto.StudentDTO;
import java.util.List;
/**
* @description: 学生表业务层接口
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
public interface StudentService extends IService<StudentDTO> {

    /**
    * 默认分页方法
    * @param studentDTO
    * @return
    */
    Page<StudentDTO> basePage(StudentDTO studentDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param studentDTO
    * @return
    */
    List<StudentDTO> findList(StudentDTO studentDTO);

}
