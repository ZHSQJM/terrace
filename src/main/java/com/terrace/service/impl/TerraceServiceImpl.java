package com.terrace.service.impl;

import com.terrace.entity.Company;
import com.terrace.repositroy.BusinessRepository;
import com.terrace.repositroy.CategoryRepository;
import com.terrace.repositroy.CompanyCategoryRepositroy;
import com.terrace.repositroy.CompanyRepository;
import com.terrace.service.ITerraceService;
import com.terrace.vo.BusinessVo;
import com.terrace.vo.CategoryVo1;
import com.terrace.vo.CompanyVo;
import com.terrace.vo.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:43
 * @package: com.terrace.service.impl
 * @description:
 */
@Service
@Slf4j
public class TerraceServiceImpl implements ITerraceService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CompanyCategoryRepositroy companyCategoryRepositroy;

    @Override
    public ResultData getAllBusiness() {

        /**
         * 1:查询出所有的业务
         * 2:根据业务查询出该业务下面所有的功能
         * 3：根据功能查询出所有的公司
         */

         List<BusinessVo> businessVoList = new ArrayList<>(10);

        //找的时所有的业务
        businessRepository.findAll().stream().forEach(a->{
            List<CategoryVo1> categoryVo1List = new ArrayList<>(10);
                BusinessVo businessvo = new BusinessVo();
                BeanUtils.copyProperties(a,businessvo);
                categoryRepository.findAllByBusinessId(a.getId()).stream().forEach(b->{
                    List<CompanyVo> companyVoList = new ArrayList<>(10);
                    CategoryVo1 categoryVo1 = new CategoryVo1();
                    BeanUtils.copyProperties(b,categoryVo1);
                    companyCategoryRepositroy.findAllByCategoryId(b.getId()).stream().forEach(c ->{
                        log.info("类目"+c.getId()+"的类目有"+b.getCategoryName());
                        CompanyVo companyVo = new CompanyVo();
                        final Company one = companyRepository.findOne(c.getCompanyId());
                        BeanUtils.copyProperties(one,companyVo);
                        companyVoList.add(companyVo);
                            });
                    categoryVo1.setCompany(companyVoList);
                    categoryVo1List.add(categoryVo1);
                });
            businessvo.setCategory(categoryVo1List);
            businessVoList.add(businessvo);
                }
        );
        return ResultData.success("获取成功",businessVoList);
    }
}
