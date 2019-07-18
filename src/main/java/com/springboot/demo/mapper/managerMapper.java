package com.springboot.demo.mapper;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface managerMapper {

    String getPasswordByName(String managerName);

    List getAllMsg();

    int upsertById(Map map);

    int deleteById(String managerId);
}
