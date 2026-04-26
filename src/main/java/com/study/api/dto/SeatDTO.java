package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity. Seat;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 座位管理数据传输层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@ToString
@TableName("seat")
public class SeatDTO extends Seat {

    /**
    * 名称
    */
    @TableField(exist = false)
    private String name;

}
