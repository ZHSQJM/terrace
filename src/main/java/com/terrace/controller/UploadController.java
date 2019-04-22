package com.terrace.controller;

import com.terrace.service.IUploadService;
import com.terrace.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 11:50
 * @package: com.terrace.controller
 * @description:
 */

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @PostMapping("/image")
    public ResultData uplaod(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        final String url = uploadService.upload(file);
        return ResultData.success("上传成功",url);
    }

    @GetMapping("/download")
    public void download(String url, HttpServletResponse response){
        uploadService.download(url);
    }
    }
