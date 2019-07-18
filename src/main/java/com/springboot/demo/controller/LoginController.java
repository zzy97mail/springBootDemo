package com.springboot.demo.controller;

import com.springboot.demo.common.R;
import com.springboot.demo.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("upsertById")
    public R upsertById(String managerId,String managerName,String managerPwd) throws Exception {
        Map map = new HashMap();
        map.put("managerId",managerId);
        map.put("managerName",managerName);
        map.put("managerPwd",managerPwd);
        managerService.upsertById(map);
        return R.ok();
    }

    @RequestMapping("deleteById")
    public R deleteById(String managerId) throws Exception {
        managerService.deleteById(managerId);
        return R.ok();
    }

}
