package com.terrace.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/3/26 10:13
 * @package: com.zblog.form
 * @description: 登录表单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserLoginForm {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 3 ,max = 12,message = "密码长度在3-12之间")
    private  String password;

    private boolean rememberMe;
}
