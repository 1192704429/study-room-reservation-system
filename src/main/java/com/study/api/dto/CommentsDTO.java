package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity.Comments;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
* @description: 贴吧信息管理数据传输层
* @author: xyl
* @create: 2025.03.11 10:41:10
*/
@Data
@ToString
@TableName("comments")
public class CommentsDTO extends Comments {

    /**
    * 发帖人姓名
    */
    @TableField(exist = false)
    private String name;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String headImg;

    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickNameTo;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headerImgTo;

    @TableField(exist = false)
    private List<CommentsDTO> commentsDTOS;
    @TableField(exist = false)
    private List<CommentsDTO> children;

    @TableField(exist = false)
    private String isOrder;

    @TableField(exist = false)
    private Long userId;

    @TableField(exist = false)
    private Boolean isLike;

    @TableField(exist = false)
    private Integer clickNum;

}
