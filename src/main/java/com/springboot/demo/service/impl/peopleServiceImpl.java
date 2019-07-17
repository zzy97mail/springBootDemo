package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.peopleMapper;
import com.springboot.demo.service.peopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class peopleServiceImpl implements peopleService {

    @Resource
    private peopleMapper peopleMapper;

    @Override
    public List selectAllMessage() throws Exception {
        return peopleMapper.selectAllMessage();
    }
}
