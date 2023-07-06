package com.zeal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("student")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

}

