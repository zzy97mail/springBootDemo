package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;
import java.util.Map;

public interface managerService {
    boolean getPasswordByName(String managerName,String pwd) throws Exception;
    PageObj getAllMsg(Integer page, Integer rows) throws Exception;
    int upsertById(Map map) throws Exception;
    int deleteById(String managerId) throws Exception;
}
