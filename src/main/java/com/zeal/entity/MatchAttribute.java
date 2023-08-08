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
@TableName("match_attribute")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class MatchAttribute {

    @ApiModelProperty(value = "编号")
    public Long id;

    @ApiModelProperty(value = "用户id")
    public Long userId;

    @ApiModelProperty(value = "性别")
    public int sex;

    @ApiModelProperty(value = "身高")
    public double height;

    @ApiModelProperty(value = "年龄")
    public double age;

    @ApiModelProperty(value = "体重")
    public double weight;

    @ApiModelProperty(value = "三围比")
    public String threeAspectRatio;

    @ApiModelProperty(value = "学历")
    public String education;

    @ApiModelProperty(value = "资产")
    public String asset;

    @ApiModelProperty(value = "年收入")
    public String annualIncome;

    @ApiModelProperty(value = "身体状况")
    public String health;

    @ApiModelProperty(value = "亲人身体状况")
    public String healthNear;

    @ApiModelProperty(value = "爱好")
    public String hobby;
}

