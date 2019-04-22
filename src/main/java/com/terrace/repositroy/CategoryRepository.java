package com.terrace.repositroy;

import com.terrace.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:26
 * @package: com.terrace.repositroy
 * @description:
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>,JpaSpecificationExecutor<Category> {


    /**
     * 通过类目名称查找类目
     * @param categoryName
     * @return
     */
    Category findAllByCategoryName(String categoryName);

    /**
     * 通过业务ID查询出该业务下面的所有类目
     * @param businessId
     * @return
     */
    List<Category> findAllByBusinessId(Integer businessId);
}
