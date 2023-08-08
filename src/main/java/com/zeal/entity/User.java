package com.zeal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * (Sutdent)表实体类
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@SuppressWarnings("serial")
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    private Long userId;

    @ApiModelProperty(value = "性别 0女1男")
    private int sex;

    @ApiModelProperty(value = "通用分数")
    private double generalScore;
}

