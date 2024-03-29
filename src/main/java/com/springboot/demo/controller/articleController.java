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
@RequestMapping("articleController")
public class articleController {

    @Autowired
    private articleService articleService;

    @RequestMapping("/getAllMsg")
    public R getAllMsg(Integer page,Integer rows,String title,String navId) throws Exception {
        return R.ok(articleService.getArticle(navId,title,page,rows));
    }

    @RequestMapping("deleteByArticleId")
    public R deleteByArticleId(String articleId) throws Exception {
        articleService.deleteByArticleId(articleId);
        return R.ok();

    }

    @RequestMapping("upsertById")
    public R upsertById(String articleId, String articleTitle, String articleContent, String navId) throws Exception{
        articleService.upsertById(articleId,articleTitle,articleContent,navId);
        return R.ok();
    }


}
