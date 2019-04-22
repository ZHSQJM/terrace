package com.terrace.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/9 15:41
 * @package: com.kinglian.screeninquiry.service
 * @description:
 */
public interface IUploadService {

    /**
     * 上传文件至oss
     * @param file
     * @return
     */
    String upload(MultipartFile file);


    /**
     * 从oss中下载
     * @param url
     */
    void download(String url);
}
