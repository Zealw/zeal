package com.zeal.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zeal.entity.DiyPercent;
import com.zeal.entity.MatchAttribute;
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
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    @ApiModelProperty(value = "编号")
    private DiyPercent diyPercent;

    @ApiModelProperty(value = "用户id")
    private MatchAttribute matchAttribute;
}

