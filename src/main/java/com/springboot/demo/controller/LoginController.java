package com.springboot.demo.controller;

import com.springboot.demo.common.R;
import com.springboot.demo.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private managerService managerService;

    @RequestMapping("getIsLogin")
    public R getIsLogin(String username,String password) throws Exception {
        if (managerService.getPasswordByName(username,password)){
            return R.ok();
        }else {
            return R.error();
        }
    }

}
