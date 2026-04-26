package com.study.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.api.entity. Manage;
import lombok.Data;
import lombok.ToString;

/**
* @description: 管理员表数据传输层
* @author: wuming
* @create: 2025.03.06 13:54:24
*/
@Data
@ToString
@TableName("manage")
public class ManageDTO extends Manage {


}
