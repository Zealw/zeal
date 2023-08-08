package com.zeal.controller;


import com.zeal.dto.MatchDTO;
import com.zeal.entity.User;
import com.zeal.service.UserService;
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
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("updateMatchInformation")
    public R updateMatchInformation(MatchDTO matchDTO) {
        return userService.updateMatchInformation(matchDTO);
    }

    @GetMapping("add")
    public R add(User user) {
        return userService.add(user);
    }
}

