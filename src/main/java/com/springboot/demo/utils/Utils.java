package com.springboot.demo.utils;

import com.github.pagehelper.Page;
import com.springboot.demo.common.PageObj;

import java.security.MessageDigest;

public class Utils {
    
    public static PageObj returnPage(PageObj pageObj, Page page,Integer pageNum,Integer rows){
        pageObj.setPageToals(page.getPages());
        pageObj.setRows(page.getResult());
        pageObj.setTotal(page.getTotal());
        pageObj.setPageNum(pageNum);
        pageObj.setPageSize(rows);
        return pageObj;
    }

    //盐，用于混交md5
    private static final String slat = "chuangji";
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
