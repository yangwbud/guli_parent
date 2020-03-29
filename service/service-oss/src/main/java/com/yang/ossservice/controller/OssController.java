package com.yang.ossservice.controller;

import com.yang.commonutils.R;
import com.yang.ossservice.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api("上传文件管理")
@CrossOrigin
@RequestMapping("/eduoss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传文件")
    @PostMapping("fileupload")
    public R fileUpload(MultipartFile file){
        String url = ossService.uploadFile(file);
        return R.ok().data("url",url);
    }
}
