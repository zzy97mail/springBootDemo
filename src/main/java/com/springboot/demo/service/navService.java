package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;

public interface navService {
    PageObj selectAllMessage(Integer page,Integer rows) throws Exception;
}
