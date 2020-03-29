package com.yang.eduservice.service;

import com.yang.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.eduservice.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-20
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoById(String courseId);
}
