package com.zeal.service;

import com.zeal.entity.DiyPercent;
import com.zeal.util.R;

/**
 * (Sutdent)表服务接口
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
public interface ScoreService {
    double getGeneralScore(Long userId);

    double getDiyScore(Long userId, Long findUserId,int sex);

    R getScore(Long userId, Long findUserId);

    R updateDiyPercent(DiyPercent percent);
}

