package com.springboot.demo.service;

import com.springboot.demo.common.PageObj;

import java.util.List;
import java.util.Map;

public interface articleService {

    List selectAllMessage() throws Exception;

    PageObj getArticle(String navId,String title,Integer page,Integer rows) throws Exception;

    int deleteByArticleId(String articleId) throws Exception;

    int upsertById(String articleId,String articleTitle,String articleContent,String navId) throws Exception;
}
