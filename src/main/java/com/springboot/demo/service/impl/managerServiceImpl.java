package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.managerMapper;
import com.springboot.demo.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class managerServiceImpl implements managerService {

    @Autowired
    private managerMapper managerMapper;

    @Override
    public boolean getPasswordByName(String managerName,String pwd) throws Exception {
        return managerMapper.getPasswordByName(managerName).equals(pwd);
    }
}
