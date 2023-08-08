package com.zeal.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeal.dao.DiyPercentDao;
import com.zeal.dao.MatchAttributeDao;
import com.zeal.dao.UserDao;
import com.zeal.dto.MatchDTO;
import com.zeal.entity.DiyPercent;
import com.zeal.entity.MatchAttribute;
import com.zeal.entity.User;
import com.zeal.service.UserService;
import com.zeal.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Sutdent)表服务实现类
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DiyPercentDao diyPercentDao;

    @Autowired
    private MatchAttributeDao matchAttributeDao;

    @Autowired
    private UserDao userDao;

    @Override
    public R updateMatchInformation(MatchDTO matchDTO) {
        MatchAttribute matchAttribute = matchDTO.getMatchAttribute();
        DiyPercent diyPercent = matchDTO.getDiyPercent();
        diyPercentDao.update(diyPercent,new UpdateWrapper<DiyPercent>().eq("user_id",diyPercent.getUserId()));
        matchAttributeDao.update(matchAttribute,new UpdateWrapper<MatchAttribute>().eq("user_id",matchAttribute.getUserId()));
        return R.success("更新成功！");
    }

    @Override
    public R add(User user) {
        int insert = userDao.insert(user);
        return R.data(insert);
    }

    @Override
    public R update(User user) {
        int update = userDao.updateById(user);
        return R.data(update);
    }

    @Override
    public R info(Long userId) {
        User user = userDao.selectById(userId);
        return R.data(user);
    }
}

