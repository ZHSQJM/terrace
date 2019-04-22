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
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:29
 * @package: com.terrace.entity
 * @description: 需求实体类
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "terrace_demand")
public class Demand {

    /**主键*/
    @Id
    @GeneratedValue
    private  Integer id;

    /**项目名称*/
    private String projectName;

    /**需求文字说明*/

    private  String need;

    /**需求附件*/
    private  String ur;

    /**预交时间*/
    private Date expectDate;

    /**预期工作日*/
    private Integer day;

    /** 价格*/
    private Double price;

    /**可否议价*/
    private Integer flag;

    /*** qq信息*/
    private  String qq;

    /*** 手机号码*/
    private  String telephone;

    /*** 邮箱*/
    private String email;

    /*** 微信*/
    private String weixin;

    /**创建时间*/
    private  Date createTime;
}
