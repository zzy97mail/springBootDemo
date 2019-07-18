package com.springboot.demo.controller;

import com.springboot.demo.common.R;
import com.springboot.demo.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LoginController")
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


    @RequestMapping("getAllMsg")
    public R getAllMsg(Integer page,Integer rows) throws Exception {
        return R.ok(managerService.getAllMsg(page,rows));
    }

}
