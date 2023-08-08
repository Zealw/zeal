package com.zeal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeal.entity.PersonAttribute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * (PersonAttribute)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Mapper
public interface PersonAttributeDao extends BaseMapper<PersonAttribute> {
    @Select("select * from person_attribute where user_id = #{userId}")
    PersonAttribute getByUserId(Long userId);
    @Select("select id from person_attribute where user_id = #{userId}")
    Long getIdByUserId(Long userId);

}

