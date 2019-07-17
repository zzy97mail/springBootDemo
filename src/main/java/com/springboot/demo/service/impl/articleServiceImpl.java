package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.articleMapper;
import com.springboot.demo.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class articleServiceImpl implements articleService {

    @Autowired
    private articleMapper articleMapper;

    @Override
    public List selectAllMessage() throws Exception {
        return articleMapper.selectAllMessage();
    }

}
