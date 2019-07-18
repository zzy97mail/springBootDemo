package com.springboot.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo.common.PageObj;
import com.springboot.demo.mapper.navMapper;
import com.springboot.demo.service.navService;
import com.springboot.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class navServiceImpl implements navService {

    @Autowired
    private navMapper navMapper;


    @Override
    public PageObj selectAllMessage(Integer page,Integer rows) throws Exception {
        PageObj pageObj = new PageObj();
        Page<?> page1 = PageHelper.startPage(page, rows, true);
        navMapper.selectAllMessage();
        return Utils.returnPage(pageObj,page1,page,rows);
    }

    @Override
    public List selectAllMsgNoPage() throws Exception {
        return navMapper.selectAllMessage();
    }
}
