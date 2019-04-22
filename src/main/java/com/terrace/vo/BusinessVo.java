package com.terrace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:38
 * @package: com.terrace.vo
 * @description: 接口返回的总格式
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BusinessVo {

    private Integer id;

    private  String  businessName;

    List<CategoryVo1> category;
}
