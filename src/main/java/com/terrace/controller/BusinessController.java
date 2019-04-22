package com.terrace.controller;

import com.terrace.entity.Business;
import com.terrace.form.BusinessForm;
import com.terrace.service.IBusinessService;
import com.terrace.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 17:02
 * @package: com.terrace.controller
 * @description:
 */

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private IBusinessService businessService;



    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "size", defaultValue = "10")  Integer size,
                             @RequestParam(value = "page", defaultValue = "0")Integer page,
                             Business business){
        ModelAndView  mv = new ModelAndView();
        Page<Business> list = businessService.findAllCompany(page, size, business);
        mv.addObject("data",list);
        mv.addObject("company",business);
        mv.setViewName("business");
        return mv;
    }

    @PostMapping("add")
    @ResponseBody
    public ResultData add(BusinessForm businessForm){
        businessService.saveOrUpdate(businessForm);
        return ResultData.success("保存成功");
    }
}
