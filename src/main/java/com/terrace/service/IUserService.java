package com.terrace.service;


import com.terrace.entity.User;

/**
 * @project: JPA
 * @author: zhs
 * @date: 2018/10/14 11:01
 * @package: com.qq.controller
 * @description: 用户相关的接口
 */
public interface IUserService {

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
     User findUserByUserName(String userName);

    /**
     * 新增注册用户
     * @param sysUserDo
     * @return
     */
     Boolean add(User sysUserDo);

     User update(User user);

    User getUserById(Integer id);


}
