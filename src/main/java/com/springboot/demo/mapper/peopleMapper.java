package com.springboot.demo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface peopleMapper {
    List selectAllMessage();
}
