package com.study.api.entity;

import com.study.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 预约管理实体类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscribe extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 学生编号
    */
    private Long stuId;
    /**
    * 自习室编号
    */
    private Long hallId;
    /**
    * 座位编号
    */
    private Long seatId;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subTime;

}
