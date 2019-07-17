package com.springboot.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo.common.PageObj;
import com.springboot.demo.common.R;
import com.springboot.demo.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class articleController {

    @Autowired
    private articleService articleService;

    @RequestMapping("/getAllMsg")
    public R getAllMsg() throws Exception {
//        PageObj pageObj = new PageObj();
//        Page<?> page = PageHelper.startPage(1, 5, true);
//        articleService.selectAllMessage();
//        pageObj.setPageToals(page.getPages());
//        pageObj.setRows(page.getResult());
//        pageObj.setTotal(page.getTotal());
//        pageObj.setPageNum(1);
//        pageObj.setPageSize(5);

        return R.ok();
    }
}
