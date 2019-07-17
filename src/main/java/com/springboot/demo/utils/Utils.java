package com.springboot.demo.utils;

import com.github.pagehelper.Page;
import com.springboot.demo.common.PageObj;

public class Utils {
    
    public static PageObj returnPage(PageObj pageObj, Page page,Integer pageNum,Integer rows){
        pageObj.setPageToals(page.getPages());
        pageObj.setRows(page.getResult());
        pageObj.setTotal(page.getTotal());
        pageObj.setPageNum(pageNum);
        pageObj.setPageSize(rows);
        return pageObj;
    }
    
}
