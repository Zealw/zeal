package com.zeal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeal.entity.GeneralPercent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * (Sutdent)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Mapper
public interface GeneralPercentDao extends BaseMapper<GeneralPercent> {
    @Select("select * from general_percent where user_id = '0'")
    GeneralPercent getGeneralScore();
    @Select("select * from general_percent where attribute = #{name} and attribute_value = #{value} and sex = #{sex}")
    GeneralPercent getByNameAndValue(String name, String value,int sex);
}

