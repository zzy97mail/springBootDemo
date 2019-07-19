package com.springboot.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo.common.PageObj;
import com.springboot.demo.mapper.managerMapper;
import com.springboot.demo.service.managerService;
import com.springboot.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class managerServiceImpl implements managerService {

    @Autowired
    private managerMapper managerMapper;

    @Override
    public String getPasswordByName(String managerName,String pwd) throws Exception {
        Map<String,String> map = managerMapper.getPasswordByName(managerName);
        if (map.get("manager_pwd").equals(Utils.encrypt(pwd+managerName))) {
            return map.get("manager_name");
        }else {
            return "";
        }
    }

    @Override
    public PageObj getAllMsg(Integer page, Integer rows) throws Exception {
        PageObj pageObj = new PageObj();
        Page<?> page1 = PageHelper.startPage(page, rows, true);
        managerMapper.getAllMsg();
        return Utils.returnPage(pageObj,page1,page,rows);
    }

    @Override
    public int upsertById(Map map) throws Exception {
        return managerMapper.upsertById(map);
    }

    @Override
    public int deleteById(String managerId) throws Exception {
        return managerMapper.deleteById(managerId);
    }
}
