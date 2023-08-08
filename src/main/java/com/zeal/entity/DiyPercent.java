package com.zeal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * (Sutdent)用户各属性占比表
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@SuppressWarnings("serial")
@Data
@TableName("diy_percent")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class DiyPercent {
    @ApiModelProperty(value = "编号")
    public Long id;

    @ApiModelProperty(value = "用户id")
    public Long userId;

    @ApiModelProperty(value = "匹配性别")
    public int matchSex;


    @ApiModelProperty(value = "身高")
    public double height;

    @ApiModelProperty(value = "年龄")
    public double age;

    @ApiModelProperty(value = "体重")
    public double weight;

    @ApiModelProperty(value = "三围比")
    public double threeAspectRatio;

    @ApiModelProperty(value = "学历")
    public double education;

    @ApiModelProperty(value = "资产")
    public double asset;

    @ApiModelProperty(value = "年收入")
    public double annualIncome;

    @ApiModelProperty(value = "身体状况")
    public double health;

    @ApiModelProperty(value = "亲人身体状况")
    public double healthNear;

    @ApiModelProperty(value = "爱好")
    public double hobby;
}

