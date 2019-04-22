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
 * @date: 2019/4/18 16:17
 * @package: com.terrace.entity
 * @description: 业务类型下面的详细功能分类
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "terrace_category")
@Data
public class Category {

    /**主键*/
    @Id
    @GeneratedValue
    private  Integer id;

    /**
     * 功能分类
     */
    private String categoryName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 业务类型
     */
    private  Integer  businessId;
}
