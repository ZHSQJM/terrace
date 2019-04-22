package com.terrace.controller;

import com.terrace.entity.Demand;
import com.terrace.service.IDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:53
 * @package: com.terrace.controller
 * @description:
 */
@Controller
@RequestMapping("demand")
public class DemandController {

    @Autowired
    private IDemandService demandService;

    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "size", defaultValue = "10")  Integer size,
                             @RequestParam(value = "page", defaultValue = "0")Integer page,
                             Demand demand){
        ModelAndView  mv = new ModelAndView();
        Page<Demand> list = demandService.findAllDemand(page, size, demand);
        mv.addObject("data",list);
        mv.addObject("demand",demand);
        mv.setViewName("demand");
        return mv;
    }
}
