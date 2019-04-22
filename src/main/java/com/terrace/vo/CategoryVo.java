package com.terrace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 14:13
 * @package: com.terrace.vo
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoryVo {

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
    private  String  businessName;
}
