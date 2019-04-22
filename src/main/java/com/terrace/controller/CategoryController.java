package com.terrace.controller;

import com.terrace.entity.Business;
import com.terrace.entity.Category;
import com.terrace.form.CategoryForm;
import com.terrace.service.IBusinessService;
import com.terrace.service.ICategoryService;
import com.terrace.vo.CategoryVo;
import com.terrace.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 14:10
 * @package: com.terrace.controller
 * @description:
 */

@Controller
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBusinessService businessService;

    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "size", defaultValue = "10")  Integer size,
                             @RequestParam(value = "page", defaultValue = "0")Integer page,
                             Category category){
        ModelAndView mv = new  ModelAndView();
        final Page<CategoryVo> list = categoryService.findAllCategory(page, size, category);
        final List<Business> all = businessService.findAll();
        mv.addObject("data",list);
        mv.addObject("all",all);
        mv.addObject("company",category);
        mv.setViewName("category");
        return mv;
    }


    @PostMapping("add")
    @ResponseBody
    public ResultData add(CategoryForm categoryForm){
        categoryService.saveOrUpdate(categoryForm);
        return ResultData.success("保存成功");
    }
}
