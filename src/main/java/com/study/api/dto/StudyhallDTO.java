package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity. Studyhall;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 自习室管理数据传输层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@ToString
@TableName("studyhall")
public class StudyhallDTO extends Studyhall {

    /**
    * 分类名称
    */
    @TableField(exist = false)
    private String typeName;

}
