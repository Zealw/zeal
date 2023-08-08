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
@TableName("general_percent")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GeneralPercent {

    @ApiModelProperty(value = "编号")
    private double id;

    @ApiModelProperty(value = "属性名")
    private String attribute;
    @ApiModelProperty(value = "属性值")
    private double attributeValue;

    @ApiModelProperty(value = "当前属性分数")
    private double attributeScore;

    @ApiModelProperty(value = "用户属性占比")
    private double attributeProportion;

    @ApiModelProperty(value = "需求占比")
    private double demandProportion;

    @ApiModelProperty(value = "当前属性占总分数比例")
    private double rateInAll;
}

