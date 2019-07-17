package com.springboot.demo.model;

import lombok.Data;

@Data
public class article {
    private String articleId;
    private String articleTitle;
    private String article_date;
    private String article_content;
    private String nav_id;
}
