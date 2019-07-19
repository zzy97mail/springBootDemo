package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;
import java.util.Map;

public interface navService {
    PageObj selectAllMessage(Integer page,Integer rows) throws Exception;
    List selectAllMsgNoPage()throws Exception;
    int upsertById(String navId,String navName,Integer navFeight);
    int deleteByNavId(String navId) throws Exception;
}
