package com.terrace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:36
 * @package: com.terrace.vo
 * @description: 不同的类目
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CategoryVo1 {

    private  Integer id;

    private  String categoryName;

    private List<CompanyVo> company;
}
