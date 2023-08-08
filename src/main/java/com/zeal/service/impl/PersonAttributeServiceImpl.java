package com.zeal.service.impl;

import com.zeal.dao.PersonAttributeDao;
import com.zeal.entity.PersonAttribute;
import com.zeal.service.PersonAttributeService;
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
public class PersonAttributeServiceImpl implements PersonAttributeService {

//    @Autowired
//    private PersonAttributeDao personAttributeDao;
//
//    /**
//     * 新增/更新个人信息
//     * @return
//     */
//    @Override
//    public R updateOwnerInformation(PersonAttribute personAttribute) {
//        Long id = personAttributeDao.getIdByUserId(personAttribute.getUserId());
//        int i;
//        if(id != null){
//            personAttribute.setId(id);
//            i = personAttributeDao.updateById(personAttribute);
//        }else{
//            i = personAttributeDao.insert(personAttribute);
//        }
//        return R.data(i);
//    }
}

