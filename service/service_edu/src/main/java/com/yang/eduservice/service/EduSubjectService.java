package com.yang.eduservice.service;

import com.yang.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.eduservice.entity.vo.OneSubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
public interface EduSubjectService extends IService<EduSubject> {
    List<String> importSubjectData(MultipartFile file);

    List<OneSubjectVo> getAllSubject();
}
