package com.yang.eduservice.service.impl;

import com.yang.eduservice.entity.EduCourse;
import com.yang.eduservice.entity.EduCourseDescription;
import com.yang.eduservice.entity.vo.CourseInfoForm;
import com.yang.eduservice.mapper.EduCourseMapper;
import com.yang.eduservice.service.EduCourseDescriptionService;
import com.yang.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    //添加课程信息
    @Override
    public String addCourseInfo(CourseInfoForm courseInfoForm) {
        //1添加课程信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if(insert==0){//添加课程信息失败
            throw  new RuntimeException("添加课程信息失败");
        }
        //1.1获取添加课程后的id
        String courseId = eduCourse.getId();
        //2添加课程描述信息
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseId);
        eduCourseDescription.setDescription(courseInfoForm.getDescription());
        courseDescriptionService.save(eduCourseDescription);
        return courseId;
    }

    //根据id课程信息
    @Override
    public CourseInfoForm getCourseInfoId(String courseId) {
        //1查询课程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        //1.1 eduCourse复制到CourseInfoForm
        CourseInfoForm courseInfoForm = new CourseInfoForm();
        BeanUtils.copyProperties(eduCourse,courseInfoForm);
        //2查询描述表
        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        courseInfoForm.setDescription(courseDescription.getDescription());

        return courseInfoForm;
    }

    @Override
    public void updateCourse(CourseInfoForm courseInfoForm) {
        //1修改课程表
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm ,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update==0){
            throw  new RuntimeException("修改课程信息失败");
        }
        //2修改描述表
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(courseInfoForm.getId());
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescriptionService.updateById(courseDescription);
    }
}
