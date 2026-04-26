package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity. Subscribe;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 预约管理数据传输层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@ToString
@TableName("subscribe")
public class SubscribeDTO extends Subscribe {

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
    /**
    * 座位编号
    */
    @TableField(exist = false)
    private String number;
    /**
    * 名称
    */
    @TableField(exist = false)
    private String name;

}
