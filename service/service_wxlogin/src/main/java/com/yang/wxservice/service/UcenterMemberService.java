package com.yang.wxservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.wxservice.entity.UcenterMember;

public interface UcenterMemberService extends IService<UcenterMember> {
    UcenterMember getWxInfoByOpenid(String openid);
}
