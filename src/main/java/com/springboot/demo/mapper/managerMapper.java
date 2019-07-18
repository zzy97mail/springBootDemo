package com.springboot.demo.mapper;


import org.springframework.stereotype.Component;

@Component
public interface managerMapper {

    String getPasswordByName(String managerName);

}
