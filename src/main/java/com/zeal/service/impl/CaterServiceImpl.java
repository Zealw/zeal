package com.zeal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeal.dao.DiyPercentDao;
import com.zeal.dao.MatchDao;
import com.zeal.dao.UserDao;
import com.zeal.entity.DiyPercent;
import com.zeal.entity.Match;
import com.zeal.entity.User;
import com.zeal.service.CaterService;
import com.zeal.service.ScoreService;
import com.zeal.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Sutdent)表服务实现类
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Service
public class CaterServiceImpl implements CaterService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private DiyPercentDao diyPercentDao;

    @Autowired
    private MatchDao matchDao;


    @Override
    public R match(Long userId) {
        User user = userDao.selectById(userId);
        DiyPercent diyPercent = diyPercentDao.getByUserId(userId);
        double userGeneralScore = user.getGeneralScore();
        List<User> users = userDao.selectList(new QueryWrapper<User>().eq("sex",diyPercent.getMatchSex()));
        Match match = new Match();
        double proportionFinal = 0;
        for(User matchUser : users){
            int matchSex = diyPercentDao.getMatchSex(matchUser.getUserId());
            if(matchSex != user.getSex()){
                continue;
            }
            int matched = matchDao.isMatched(userId, matchUser.getUserId());
            if(matched > 0){
                continue;
            }
            double matcherGeneralScore = matchUser.getGeneralScore();
            double matcherScoreInUserRule = scoreService.getDiyScore(userId, matchUser.getUserId(),matchSex);
            double userScoreInMatcherRule = scoreService.getDiyScore(matchUser.getUserId(),userId ,matchSex);
            double userScore = userGeneralScore + matcherScoreInUserRule;
            double matcherScore = matcherGeneralScore + userScoreInMatcherRule;
            double proportion;
            if(userScore < matcherScore){
                proportion = (userScore) / (matcherScore);
            }else{
                proportion = (matcherScore) / (userScore);
            }

            if(proportion < 0.8){
                continue;
            }
            if(proportion > proportionFinal){
                match.setProportion(proportion);
                match.setUserId(userId);
                match.setMatchUserId(match.getMatchUserId());
            }
        }
        matchDao.insert(match);
        return R.data((match));
    }
}

