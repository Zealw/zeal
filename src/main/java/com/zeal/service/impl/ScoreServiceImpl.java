package com.zeal.service.impl;

import com.zeal.dao.*;
import com.zeal.entity.PersonAttribute;
import com.zeal.entity.DiyPercent;
import com.zeal.entity.GeneralPercent;
import com.zeal.service.ScoreService;
import com.zeal.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * (Sutdent)表服务实现类
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonAttributeDao personAttributeDao;

    @Autowired
    private DiyPercentDao diyPercentDao;

    @Autowired
    private GeneralPercentDao personAttributeScoreDao;

    @Override
    public double getGeneralScore(Long userId) {
        PersonAttribute personAttribute = personAttributeDao.getByUserId(userId);
        Field[] fields = PersonAttribute.class.getDeclaredFields();
        double score = 0.0;
        for(Field field : fields){
            try {
                double singleScore = getSingleScore(field.getName(), (String) field.get(personAttribute),personAttribute.sex);
                score += singleScore;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (score);
    }


    @Override
    public double getDiyScore(Long userId, Long findUserId,int sex) {
        DiyPercent attributePercent = diyPercentDao.getByUserId(userId);
        PersonAttribute attribute = personAttributeDao.getByUserId(findUserId);
        double score = 0.0;
        Field[] fields = PersonAttribute.class.getDeclaredFields();
        for(Field field : fields){
            try {
                double singleScore = getDiySingleScore(field.getName(), (String) field.get(attribute),(double) field.get(attributePercent),sex);
                score += singleScore;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (score);
    }

    private double getSingleScore(String field,String param,int sex) {
        GeneralPercent generalScore = personAttributeScoreDao.getByNameAndValue(field,String.valueOf(param),sex);
        return generalScore.getAttributeScore() * generalScore.getRateInAll();
    }

    private double getDiySingleScore(String field,String param,double percent,int sex) {
        GeneralPercent generalScore = personAttributeScoreDao.getByNameAndValue(field,String.valueOf(param),sex);
        return generalScore.getAttributeScore() * percent;
    }


//    @Override
//    public R getScorep(Long userId, Long findUserId) {
//
//        return null;
//    }

    /**
     * @param userId
     * @param findUserId
     * @return
     */
    @Override
    public R getScore(Long userId, Long findUserId) {

        return null;
    }

    /**
     *
     * 更新个人DIY占比
     * @return
     */
    @Override
    public R updateDiyPercent(DiyPercent percent) {
        Long id = diyPercentDao.getIdByUserId(percent.getUserId());
        int i;
        if(id != null){
            percent.setId(id);
            i = diyPercentDao.updateById(percent);
        }else{
            i = diyPercentDao.insert(percent);
        }
        return R.data(i);
    }
}

