package com.terrace.service.impl;

import com.terrace.entity.User;
import com.terrace.repositroy.UserRepostory;
import com.terrace.service.IUserService;
import com.terrace.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: JPA
 * @author: zhs
 * @date: 2018/10/14 11:01
 * @package: com.qq.controller
 * @description:
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserRepostory userRepostory;



    @Override
    public User findUserByUserName(String userName) {
        return userRepostory.findUserByUsername(userName);
    }

    @Override
    public Boolean add(User user) {
        final User user1 = userRepostory.findUserByUsername(user.getUsername());
        if(user1 != null){
            return  false;
        }else {
            String password = MD5Utils.md5(user.getPassword());
            user.setPassword(password);
             userRepostory.save(user);

            return true;
        }
    }

    @Override
    public User update(User user) {
        return null;
    }


    @Override
    public User getUserById(Integer id) {
        return userRepostory.getOne(id);
    }

}
