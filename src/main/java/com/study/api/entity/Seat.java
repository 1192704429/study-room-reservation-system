package com.study.api.entity;

import com.study.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 座位管理实体类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seat extends BaseEntity {

    /**
    * 序号
    */
    private Long id;
    /**
    * 座位编号
    */
    private String number;
    /**
    * 所属自习室
    */
    private Long hallId;
    /**
    * 二维码图片
    */
    private String qrCode;
    /**
    * 当前状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
