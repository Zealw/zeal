package com.zeal.controller;


import com.zeal.service.StudentService;
import com.zeal.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Sutdent)表控制层
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@RestController
@RequestMapping("student")
@AllArgsConstructor
@Slf4j
public class StudentController  {
    @Autowired
    private StudentService service;

    @GetMapping("zeal")
    public String delete() {
        return "zealer";
    }

    @GetMapping("sql")
    public R get() {
        return service.get();
    }

}

