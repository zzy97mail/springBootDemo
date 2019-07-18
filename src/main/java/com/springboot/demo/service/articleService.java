package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;

public interface articleService {

    List selectAllMessage() throws Exception;

    PageObj getArticle(String navId,String title,Integer page,Integer rows) throws Exception;
}
