package com.zeal.controller;


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
@RequestMapping("student")
public class SutdentController  {
    @GetMapping("zeal")
    public String delete() {
        return "zeal";
    }
}

