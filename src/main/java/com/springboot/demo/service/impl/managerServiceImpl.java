package com.springboot.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo.common.PageObj;
import com.springboot.demo.mapper.managerMapper;
import com.springboot.demo.service.managerService;
import com.springboot.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class managerServiceImpl implements managerService {

    @Autowired
    private managerMapper managerMapper;

    @Override
    public boolean getPasswordByName(String managerName,String pwd) throws Exception {
        return managerMapper.getPasswordByName(managerName).equals(pwd);
    }

    @Override
    public PageObj getAllMsg(Integer page, Integer rows) throws Exception {
        PageObj pageObj = new PageObj();
        Page<?> page1 = PageHelper.startPage(page, rows, true);
        managerMapper.getAllMsg();
        return Utils.returnPage(pageObj,page1,page,rows);
    }
}