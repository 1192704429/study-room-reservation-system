package com.study.api.entity;

import com.study.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 自习室管理实体类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Studyhall extends BaseEntity {

    /**
    * 自习室编号
    */
    private Long id;
    /**
    * 名称
    */
    private String name;
    /**
    * 简介
    */
    private String info;
    /**
    * 所在位置
    */
    private String address;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 封面图片
    */
    private String img;
    /**
    * 座位数
    */
    private Integer num;
    /**
    * 当前空闲
    */
    private Integer currentNum;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 所属分类
    */
    private Long typeId;


}
