package com.terrace.service;

import com.terrace.vo.ResultData;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:41
 * @package: com.terrace.service
 * @description: 前端需要的接口
 */
public interface ITerraceService {

    /**
     * 首页需要的公司列表
     * @return
     */
    ResultData getAllBusiness();
}
