package com.terrace.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/9 10:31
 * @package: com.meals.entity
 * @description:
 */

@Entity
@Data
@Table(name = "terrace_user")
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户名
     */
    @Column(length = 16,name = "username",nullable = false)
    private String username;


    /**
     * 密码
     */
    @Column(name = "password",nullable =false,length = 32)
    private  String  password;

    /**
     * 创建时间
     */
    private  Date createTime;

    /**
     * 修改时间
     */
    private Date  updateTime;


}
