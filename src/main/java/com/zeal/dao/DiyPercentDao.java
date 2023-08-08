package com.zeal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeal.entity.DiyPercent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * (Sutdent)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Mapper
public interface DiyPercentDao extends BaseMapper<DiyPercent> {
    @Select("select * from diy_percent where user_id = #{userId}")
    DiyPercent getByUserId(Long userId);

    @Update("select id where user_id = #{userId}")
    Long getIdByUserId(Long userId);

    @Select("select match_sex from diy_percent where user_id = #{userId}")
    int getMatchSex(Long userId);

}

