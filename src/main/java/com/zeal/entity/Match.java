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
@TableName("match")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "匹配度")
    private double proportion;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "匹配用户id")
    private Long matchUserId;
}

