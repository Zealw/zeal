package com.zeal.controller;


import com.zeal.service.CaterService;
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
@RequestMapping("cater")
@Slf4j
public class CaterController {

    @Autowired
    private CaterService caterService;

    @GetMapping("match")
    public R match(Long userId) {
        return caterService.match(userId);
    }
}

