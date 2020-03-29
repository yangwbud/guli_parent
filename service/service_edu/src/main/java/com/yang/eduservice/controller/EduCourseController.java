package com.yang.eduservice.controller;


import com.yang.commonutils.R;
import com.yang.eduservice.entity.vo.CourseInfoForm;
import com.yang.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
@Api(description="课程管理")
@RestController
@RequestMapping("/eduservice/educourse")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "添加课程信息")
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoForm courseInfoForm){
        String courseId  = courseService.addCourseInfo(courseInfoForm);
        return R.ok().data("courseId",courseId);
    }

    @ApiOperation(value = "根据id课程信息")
    @GetMapping("{courseId}")
    public R getCourseInfoId(@PathVariable String courseId){
        CourseInfoForm courseInfoForm = courseService.getCourseInfoId(courseId);
        return R.ok().data("courseInfo",courseInfoForm);
    }


    @ApiOperation(value = "修改课程信息")
    @PostMapping("updateCourse")
    public R updateCourse(@RequestBody CourseInfoForm courseInfoForm){
        courseService.updateCourse(courseInfoForm);
        return R.ok();
    }

}

