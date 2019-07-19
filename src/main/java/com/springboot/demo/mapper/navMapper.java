package com.springboot.demo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface navMapper {

    List selectAllMessage();

    int upsertById(Map map);

    int deleteByNavId(String navId);
}
