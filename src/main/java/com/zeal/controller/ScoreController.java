package com.zeal.controller;


import com.zeal.entity.DiyPercent;
import com.zeal.service.CaterService;
import com.zeal.service.ScoreService;
import com.zeal.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Sutdent)表控制层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@RestController
@RequestMapping("score")
@Slf4j
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("updateDiyPercent")
    public R updateDiyPercent(DiyPercent diyPercent) {
        return scoreService.updateDiyPercent(diyPercent);
    }

    @GetMapping("getGeneralScore")
    public R getGeneralScore(Long userId) {
        return R.data(scoreService.getGeneralScore(userId));
    }

    @GetMapping("getDiyScore")
    public R getDiyScore(Long userId, Long findUserId,int sex) {
        return  R.data(scoreService.getDiyScore(userId,findUserId,sex));
    }
}

