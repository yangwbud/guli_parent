package com.yang.mvntest.dao.impl;

import com.yang.mvntest.dao.HbaseDao;

import org.springframework.stereotype.Repository;



@Repository
public class HbaseDaoImpl implements HbaseDao {


    @Override
    public String add(Integer id) {
        if(id.intValue()==1){
            return "1 is one";
        }else if(id.intValue()==2){
            return "2 is two!";
        }else if(id.intValue()==3){
            return "3 is three!";
        }
        return "fuck off!";
    }
}
