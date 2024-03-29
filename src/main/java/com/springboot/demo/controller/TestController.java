package com.springboot.demo.controller;

import com.springboot.demo.common.R;
import com.springboot.demo.mapper.articleMapper;
import com.springboot.demo.mapper.peopleMapper;
import com.springboot.demo.service.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private articleMapper articleMapper;

    @RequestMapping("test")
    public R GetPeople() throws Exception{
        return R.ok(articleMapper.selectAllMessage());
    }


}
