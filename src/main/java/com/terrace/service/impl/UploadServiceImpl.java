package com.terrace.service.impl;

import com.terrace.service.IUploadService;
import com.terrace.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/9 15:42
 * @package: com.kinglian.screeninquiry.service.impl
 * @description:
 */
@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;


    @Override
    public String upload(MultipartFile file) {
        String uploadUrl="";
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        try {
            if (file!=null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    uploadUrl = aliyunOSSUtil.upLoad(newFile);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uploadUrl;
    }

    @Override
    public void download(String url) {
        aliyunOSSUtil.download(url);
    }
    }

