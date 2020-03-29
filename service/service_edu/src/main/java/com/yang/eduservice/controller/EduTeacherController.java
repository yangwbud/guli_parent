package com.yang.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.commonutils.R;
import com.yang.eduservice.entity.EduTeacher;
import com.yang.eduservice.entity.vo.TeacherQuery;
import com.yang.eduservice.service.EduTeacherService;
import com.yang.servicebase.handler.YangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-10
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/eduteacher")
@CrossOrigin
public class EduTeacherController {


    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping
    @ApiOperation(value = "所有讲师")
    public R getAllTeachers(){
        List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("items",list);
    }


    @DeleteMapping("{id}")
    @ApiOperation("根据id删除讲师")
    public R deleteTeacherId(@PathVariable String id){
        boolean remove = eduTeacherService.removeById(id);
        return R.ok();
    }

    @GetMapping("/getteachers/{current}/{limit}/")
    @ApiOperation(value = "分页查询讲师")
    public R getAllTeachersPage(@PathVariable("current") Long current,@PathVariable("limit") Long limit){
        Page<EduTeacher> page = new Page<>(current, limit);

        //List<EduTeacher> list = eduTeacherService.list(null);
        eduTeacherService.page(page, null);
        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",records);
        return R.ok().data("items",records).data("total",total);
    }


    @PostMapping("/getteacherscondition/{current}/{limit}/")
    @ApiOperation(value = "带条件的分页查询讲师")
    public R getAllTeachersPageCondition(@PathVariable("current") Long current,
                                         @PathVariable("limit") Long limit,
                                         @RequestBody TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page<>(current, limit);

        //List<EduTeacher> list = eduTeacherService.list(null);
        //eduTeacherService.page(page, null);
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        eduTeacherService.page(page, wrapper);
        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();


        return R.ok().data("items",records).data("total",total);
    }

    @PostMapping("/addteachers/")
    @ApiOperation(value = "添加讲师")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else return R.error();

    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/getTeacherById/{id}")
    public R getTeacherById(@PathVariable("id") String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);

        return R.ok().data("eduTeacher",eduTeacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping("updataTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b){
            return R.ok();
        }else return R.error();
    }


}

