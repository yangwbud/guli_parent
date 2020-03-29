package com.yang.mvntest.controller;


import com.yang.mvntest.service.HbaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("laoyang")
public class HbaseController {

    @Resource
    private HbaseService hbaseService;

    @GetMapping("{id}")
    public String getUser(@PathVariable("id") Integer id){

        return hbaseService.add(id);
    }
}
