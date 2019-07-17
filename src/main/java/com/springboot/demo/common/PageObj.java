package com.springboot.demo.common;

import java.io.Serializable;
import java.util.List;

public class PageObj implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // 总数
    private long total;

    // 结果集
    private List<?> rows;

    // 当前页数
    private int pageNum;

    // 每页条数
    private int pageSize;

    //总页数
    private int pageToals;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageToals() {
        return pageToals;
    }

    public void setPageToals(int pageToals) {
        this.pageToals = pageToals;
    }
}
