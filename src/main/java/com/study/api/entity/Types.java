package com.study.api.entity;

import com.study.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 自习室分类实体类
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Types extends BaseEntity {

    /**
    * 分类编号
    */
    private Long id;
    /**
    * 分类名称
    */
    private String typeName;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
