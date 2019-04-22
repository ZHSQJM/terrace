package com.terrace.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:39
 * @package: com.terrace.form
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DemandForm {


    /**需求文字说明*/

    @NotEmpty(message = "请输入需求说明")
    private  String need;

    /**需求附件*/

    private  String ur;

    private String projectName;

    /**预交时间*/
   // @NotEmpty(message = "请输入预交时间")
    private Date expectDate;

    /**预期工作日*/
    @NotNull(message = "请输入预期工作日")
    private Integer day;

    /** 价格*/
    @NotNull(message = "请输入价格")
    private Double price;

    /**可否议价*/
    private Integer flag;

    /*** qq信息*/
    private  String qq;

    /*** 手机号码*/
    private  String telephone;

    /*** 邮箱*/
    @Email(message = "请输入正确的邮箱信息")
    private String email;

    /*** 微信*/
    private String weixin;
}
