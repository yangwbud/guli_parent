package com.yang.eduservice.service;

import com.yang.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.eduservice.entity.vo.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
public interface EduCourseService extends IService<EduCourse> {

    String addCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoId(String courseId);

    void updateCourse(CourseInfoForm courseInfoForm);
}
