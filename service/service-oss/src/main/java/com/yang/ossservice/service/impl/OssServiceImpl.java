package com.yang.ossservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.yang.ossservice.service.OssService;
import com.yang.ossservice.utils.ContantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFile(MultipartFile file) {
        String url=null;
        String endpoint = ContantPropertiesUtils.ENDPOINT;
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ContantPropertiesUtils.KEYID;
        String accessKeySecret = ContantPropertiesUtils.KEYSECRET;
        String bucketName = ContantPropertiesUtils.BUCKETNAME;
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String filename = file.getOriginalFilename();
            filename = filename+ UUID.randomUUID().toString();
            String path = new DateTime().toString("yyyy/MM/dd");
            filename = path+"/"+filename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, filename, inputStream);
            ossClient.shutdown();
            //https://guli-edu-yang.oss-cn-beijing.aliyuncs.com/hive-site.xml
             url = "https://"+bucketName+"."+endpoint+"/"+filename;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
