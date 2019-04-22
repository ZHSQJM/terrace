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
 * @date: 2019/4/18 16:09
 * @package: com.terrace.entity
 * @description:  业务类型
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "terrace_business")
@Data
public class Business {

    @Id
    @GeneratedValue
    private  Integer id;


    /**业务名称*/
    private  String businessName;

    /**创建时间*/
    private Date createTime;

    /**业务排序*/
    private Integer sort;
}
