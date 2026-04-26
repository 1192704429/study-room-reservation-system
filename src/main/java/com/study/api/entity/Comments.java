package com.study.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @description: 贴吧信息管理实体类
 * @author: xyl
 * @create: 2025.03.11 10:41:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comments extends BaseEntity {

    /**
     * 贴吧编号
     */
    private Long id;
    /**
     * 评论学生编号
     */
    private Long fromStuId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 回复人编号
     */
    private Long toStuId;

    private Integer type;
    /**
     * 父级评论编号
     */
    private Long parentId;
    /**
     * 图片列表
     */
    private String imgList;
    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
