package com.springboot.demo.controller;


import com.springboot.demo.common.R;
import com.springboot.demo.service.navService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("navController")
public class navController {

    @Autowired
    private navService navService;

    @RequestMapping("getAllMsgByPage")
    public R getAllMsgByPage(Integer page,Integer rows) throws Exception {
        return R.ok(navService.selectAllMessage(page,rows));
    }

    @RequestMapping("getAllMsgNoPage")
    public R getAllMsgNoPage() throws Exception{
        return R.ok(navService.selectAllMsgNoPage());
    }

    @RequestMapping("upsertById")
    public R upsertById(String navId, String navName, Integer navFeight) throws Exception{
        navService.upsertById(navId,navName,navFeight);
        return R.ok();
    }

}
