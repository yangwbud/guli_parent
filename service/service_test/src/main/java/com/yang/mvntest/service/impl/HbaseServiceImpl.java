package com.yang.mvntest.service.impl;

import com.yang.mvntest.dao.HbaseDao;

import com.yang.mvntest.service.HbaseService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class HbaseServiceImpl implements HbaseService {
    @Resource
    private HbaseDao hbaseDao;


    @Override
    public String add(Integer id) {
        return hbaseDao.add(id);
    }
}
