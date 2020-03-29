package com.yang.wxservice.controller;

import com.yang.wxservice.service.UcenterMemberService;
import com.yang.wxservice.utils.ConstantPropertiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Api(description="微信扫码登录")
@Controller
@RequestMapping("/api/ucenter/wx")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    UcenterMemberService memberService;

    @ApiOperation(value = "生成微信登录二维码方法")
    @GetMapping("login")
    public String login(){
        //方案一：拼接url字符串
        // https://open.weixin.qq.com/connect/qrconnect?
        // appid=APPID&redirect_uri=REDIRECT_URI
        // &response_type=code&scope=SCOPE&state=STATE#wechat_redirect
        //方案二：
        //搭建开发平台授权URL
        //使用占位符%s，传递需要的参数
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";
        String wxOpenRedirectUrl = ConstantPropertiesUtil.WX_OPEN_REDIRECT_URL;

        try {
            wxOpenRedirectUrl = URLEncoder.encode(wxOpenRedirectUrl,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //向%s传递参数
        String wxUrl = String.format(
                baseUrl,
                ConstantPropertiesUtil.WX_OPEN_APP_ID,
                wxOpenRedirectUrl,
                "wxstguigu"
        );
        //重定向
        return "redirect:" + wxUrl;

    }


}
