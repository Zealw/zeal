package com.zeal.service.impl;

import com.zeal.dao.StudentDao;
import com.zeal.service.StudentService;
import com.zeal.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Sutdent)表服务实现类
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public R get() {
        return R.data(studentDao.selectById(1));
    }
}

