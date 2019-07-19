package com.springboot.demo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface articleMapper {

    List selectAllMessage();

    List getArticle(Map map);

    int deleteByArticleId(String articleId);
}
