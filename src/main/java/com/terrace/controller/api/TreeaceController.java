package com.terrace.controller.api;

import com.terrace.form.DemandForm;
import com.terrace.service.IDemandService;
import com.terrace.service.ITerraceService;
import com.terrace.service.IUploadService;
import com.terrace.service.impl.WebSocket;
import com.terrace.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:41
 * @package: com.terrace.controller.api
 * @description:
 */

@RestController
@RequestMapping("treeace")
public class TreeaceController {


    @Autowired
    private ITerraceService terraceService;

    @Autowired
    private IUploadService uploadService;

    @Autowired
    private IDemandService demandService;

    @Autowired
    private WebSocket webSocket;


    /**
     * 获取首页列表
     * @return
     */
    @GetMapping("getbuinsee")
    public ResultData getBuinsee(){
        return terraceService.getAllBusiness();
    }

    /**
     * 获取需求列表
     * @return
     */
    @PostMapping(value = "postyouwant")
    @ResponseBody
    public  ResultData PostYouWant(@Validated DemandForm demandForm,@RequestParam("file") MultipartFile file){
        final String url = uploadService.upload(file);
        demandForm.setUr(url);
        demandService.addDemand(demandForm);
        webSocket.onMessage("有新的订单");
        return  ResultData.success("请求成功");
    }
}
