package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity. Borrow;
import lombok.Data;
import lombok.ToString;

/**
* @description: 借还管理数据传输层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@ToString
@TableName("borrow")
public class BorrowDTO extends Borrow {

    /**
    * 学生姓名
    */
    @TableField(exist = false)
    private String stuName;
    /**
    * 照片
    */
    @TableField(exist = false)
    private String stuImg;

}
