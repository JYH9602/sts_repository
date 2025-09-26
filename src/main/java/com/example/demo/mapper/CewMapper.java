package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.dto.CewDto;

@Mapper
public interface CewMapper {
    List<CewDto> findAll();
    CewDto findByLoginId(String loginId);
    void insert(CewDto cew);
    void update(CewDto cew);
    void delete(String userId);
}