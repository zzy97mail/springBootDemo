package com.springboot.demo.controller;

import com.springboot.demo.common.R;
import com.springboot.demo.service.managerService;
import com.springboot.demo.utils.Utils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("LoginController")
public class LoginController {

    @Autowired
    private managerService managerService;

    @RequestMapping("getIsLogin")
    public R getIsLogin(String username,String password) throws Exception {
        String name = managerService.getPasswordByName(username,password);
        if (name.equals("")){
            return R.error();
        }else {
            return R.ok(name);
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
        map.put("managerPwd", Utils.encrypt(managerPwd+managerId));
        managerService.upsertById(map);
        return R.ok();
    }

    @RequestMapping("deleteById")
    public R deleteById(String managerId) throws Exception {
        managerService.deleteById(managerId);
        return R.ok();
    }

}
