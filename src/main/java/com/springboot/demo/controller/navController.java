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

}
