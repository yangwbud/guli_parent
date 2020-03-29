package com.yang.eduservice.controller;

import com.yang.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "模拟登陆")
@RestController
@RequestMapping("/eduuser")
@CrossOrigin
public class EduLoginController {

    @PostMapping("login")
    @ApiOperation(value = "模拟登陆")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    @ApiOperation(value = "模拟获取信息")
    public R info(){
        return R.ok().data("roles","admin").data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
