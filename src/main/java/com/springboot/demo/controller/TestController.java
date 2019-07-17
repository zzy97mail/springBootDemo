package com.springboot.demo.controller;

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
    private peopleService service;


    @RequestMapping("test")
    public List GetPeople() throws Exception{
        return service.selectAllMessage();
    }


}
