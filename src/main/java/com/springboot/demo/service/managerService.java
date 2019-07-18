package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;

public interface managerService {
    boolean getPasswordByName(String managerName,String pwd) throws Exception;
    PageObj getAllMsg(Integer page, Integer rows) throws Exception;
}
