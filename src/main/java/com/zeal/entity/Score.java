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
@TableName("score")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "身高")
    private double height;

    @ApiModelProperty(value = "年龄")
    private double age;

    @ApiModelProperty(value = "体重")
    private double weight;

    @ApiModelProperty(value = "三围比")
    private double threeAspectRatio;

    @ApiModelProperty(value = "学历")
    private double education;

    @ApiModelProperty(value = "资产")
    private double asset;

    @ApiModelProperty(value = "年收入")
    private double annualIncome;

    @ApiModelProperty(value = "身体状况")
    private double health;

    @ApiModelProperty(value = "亲人身体状况")
    private double healthNear;

    @ApiModelProperty(value = "爱好")
    private double hobby;
}

