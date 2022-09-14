package com.ruirui.mock.service;

import com.ruirui.mock.dao.UserDao;
import com.ruirui.mock.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/24 2:17 下午
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    public Boolean checkExistIdEqualsOne(){
        User userById = userDao.getUserById(1);
        if(userById != null){
            return false;
        }else {
            return true;
        }
    }
}
