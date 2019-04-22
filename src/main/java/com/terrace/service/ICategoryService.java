package com.terrace.service;

import com.terrace.entity.Category;
import com.terrace.form.CategoryForm;
import com.terrace.vo.CategoryVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:50
 * @package: com.terrace.service
 * @description: 类型接口层
 */
public interface ICategoryService {

    /**
     * 是否添加或者更新成功
     * @param categoryForm
     * @return
     */
    Boolean saveOrUpdate(CategoryForm categoryForm);


    Page<CategoryVo> findAllCategory(Integer page, Integer size, Category category);

    List<Category> findAllByBusinessId(Integer business);

}
