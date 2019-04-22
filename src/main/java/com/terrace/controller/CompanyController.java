package com.terrace.controller;

import com.terrace.entity.Business;
import com.terrace.entity.Company;
import com.terrace.form.ComPanyForm;
import com.terrace.service.IBusinessService;
import com.terrace.service.ICategoryService;
import com.terrace.service.ICompanyService;
import com.terrace.service.IUploadService;
import com.terrace.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 09:41
 * @package: com.terrace.controller
 * @description: 展示公式列表
 */

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IUploadService uploadService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private ICategoryService categoryService;



    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "size", defaultValue = "10")  Integer size,
                             @RequestParam(value = "page", defaultValue = "0")Integer page,
                             Company company){
         ModelAndView  mv = new ModelAndView();
         Page<Company> list = companyService.findAllCompany(page, size, company);
         final List<Business> all = businessService.findAll();
         mv.addObject("all",all);
         mv.addObject("data",list);
         mv.addObject("company",company);
         mv.setViewName("company");
        return mv;
    }


    @GetMapping("findCategoryById/{id}")
    @ResponseBody
    public ResultData findAllByBusinessId(@PathVariable("id") Integer id){
        return ResultData.success("获取成功",categoryService.findAllByBusinessId(id));
    }
    @PostMapping("add")
    @ResponseBody
    public ResultData add(ComPanyForm comPanyForm,@RequestParam("file") MultipartFile file){
        final String logo = uploadService.upload(file);
        comPanyForm.setLogo(logo);
        companyService.saveOrUpdate(comPanyForm);
        return ResultData.success("保存成功");
    }


    @PostMapping("/distribution")
    @ResponseBody
    public  ResultData  distribution(int companyId,Integer [] ids){
        companyService.distribution(companyId,ids);
        return ResultData.success("操作成功");
    }

}
