package com.terrace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @project: terrace
 * @author: zhs
 * @date: 2019/4/18 16:03
 * @package: com.terrace.entity
 * @description: 公司的实体类
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "terrace_company")
@Data
public class Company {

    /**主键*/
    @Id
    @GeneratedValue
    private  Integer id;

    /**公司名称*/
    private  String companyName;

    /**公司logo*/
    private  String logo;

    /**公司手机号*/
    private String telephone;

    /**公司简介**/
    private String decription;

    private Date createTime;

    private Date updateTime;

}
