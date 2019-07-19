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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @Override
    public int upsertById(String navId, String navName, Integer navFeight) {
        if (navId.equals(""))
            navId = UUID.randomUUID().toString();
        Map map = new HashMap();
        map.put("navId",navId);
        map.put("navName",navName);
        map.put("navFeight",navFeight);
        return navMapper.upsertById(map);
    }

    @Override
    public int deleteByNavId(String navId) throws Exception {
        return navMapper.deleteByNavId(navId);
    }

}
