package com.terrace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:33
 * @package: com.terrace.vo
 * @description:
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CompanyVo {

    /**
     * 公司唯一标识
     */
    private Integer id;

    /**
     * 公司的logo
     */
    private  String logo;

    /**
     * 公司名称
     */
    private String  companyName;
}
