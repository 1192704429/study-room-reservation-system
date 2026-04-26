package com.study.api.entity;

import com.study.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 借还管理实体类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Borrow extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 学生编号
    */
    private Long stuId;
    /**
    * 物品名称
    */
    private String name;
    /**
    * 物品图片
    */
    private String img;
    /**
    * 简介
    */
    private String info;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 联系方式
    */
    private String tel;


}
