package com.zeal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeal.entity.Match;
import com.zeal.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * (Sutdent)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Mapper
public interface MatchDao extends BaseMapper<Match> {

    @Select("select 1 from match where (user_id = #{userId} or matcher_id = #{userId}) and (user_id = #{matcherId} or matcher_id = #{matcherId})")
    int isMatched(Long userId,Long matcherId);

}

