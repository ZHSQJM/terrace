package com.terrace.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:34
 * @package: com.terrace.form
 * @description: 表单提交类
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class ComPanyForm {


    private  Integer id;

    /**公司名称*/
    @NotEmpty(message = "公司名称不能为空")
    private  String companyName;

    /**公司logo*/

    private  String logo;

    /**公司简介**/
    private String decription;

    /**公司手机号*/
    @NotEmpty(message = "公司手机号码不能为空")
    private String telephone;
}
