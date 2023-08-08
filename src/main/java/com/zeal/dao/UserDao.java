package com.zeal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeal.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Sutdent)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

