package com.terrace.repositroy;

import com.terrace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @project: JPA
 * @author: zhs
 * @date: 2018/10/14 11:01
 * @package: com.qq.controller
 * @description:
 */
@Repository
public interface UserRepostory extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {


    
    
  /**
   * decription: 通过用户名查询用户
   * @param userName
   * @return: com.qq.entity.SysUser
   * @auther: zhs
   * @date: 2018/10/15 14:38
   * @remarks:
   */
    User findUserByUsername(String userName);



}
