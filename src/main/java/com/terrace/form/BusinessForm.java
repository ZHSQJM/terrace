package com.terrace.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @project: terrace
 * @author: zhs
 * @date: 2019/4/18 16:09
 * @package: com.terrace.entity
 * @description:  业务类型
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class BusinessForm {

    private  Integer id;


    /**业务名称*/
    @NotEmpty(message = "业务名称不能为空")
    private  String BusinessName;

    /**创建时间*/
    private Date CreateTime;

    /**业务排序*/
    private Integer sort;
}
