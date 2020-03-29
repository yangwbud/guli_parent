package com.yang.eduservice.controller;


import com.yang.commonutils.R;
import com.yang.eduservice.entity.vo.OneSubjectVo;
import com.yang.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
@Api(description = "课程分类管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/edusubject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation(value = "添加课程分类")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        //调用接口
        //返回错误的提示信息
        List<String> msgList = eduSubjectService.importSubjectData(file);
        if(msgList.size()==0){//集合没有数据，成功
            return R.ok();
        }else{
            return R.error().data("msgList",msgList);
        }
    }

    @ApiOperation(value = "查询课程分类")
    @GetMapping
    public R getAllSubject(){
        List<OneSubjectVo> allSubject = eduSubjectService.getAllSubject();
        return R.ok().data("allSubject",allSubject);
    }

}

