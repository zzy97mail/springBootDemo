package com.springboot.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo.common.PageObj;
import com.springboot.demo.mapper.articleMapper;
import com.springboot.demo.service.articleService;
import com.springboot.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class articleServiceImpl implements articleService {

    @Autowired
    private articleMapper articleMapper;

    @Override
    public List selectAllMessage() throws Exception {
        return articleMapper.selectAllMessage();
    }

    @Override
    public PageObj getArticle(String navId, String title, Integer page, Integer rows) throws Exception {
        Map map = new HashMap();
        map.put("title", "%" + title + "%");
        map.put("navId", navId);
        PageObj pageObj = new PageObj();
        Page<?> page1 = PageHelper.startPage(page, rows, true);
        articleMapper.getArticle(map);
        return Utils.returnPage(pageObj, page1, page, rows);
    }

}
