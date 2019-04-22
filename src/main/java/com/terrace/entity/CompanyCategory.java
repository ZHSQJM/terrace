package com.terrace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:36
 * @package: com.terrace.entity
 * @description:
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "company_category")
@Data
public class CompanyCategory {


    @Id
    @GeneratedValue
    private Integer id;

    private  Integer  companyId;

    private Integer categoryId;

}
