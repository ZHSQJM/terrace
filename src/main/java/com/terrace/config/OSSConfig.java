package com.terrace.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 09:34
 * @package: com.terrace.config
 * @description:
 */
@Data
@Component
@Configuration
public class OSSConfig {

    @Value("${terrace.endpoint}")
    private   String LXIMAGE_END_POINT;
    @Value("${terrace.keyid}")
    private  String LXIMAGE_ACCESS_KEY_ID;
    @Value("${terrace.keysecret}")
    private  String LXIMAGE_ACCESS_KEY_SECRET;
    @Value("${terrace.filehost}")
    private  String LXIMAGE_FILE_HOST;
    @Value("${terrace.bucketname}")
    private  String LXIMAGE_BUCKET_NAME;
}
