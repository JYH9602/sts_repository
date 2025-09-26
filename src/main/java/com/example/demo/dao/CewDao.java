package com.example.demo.dao;

import com.example.demo.dto.CewDto;
import com.example.demo.mapper.CewMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CewDao {
    private final CewMapper mapper;

    public CewDao(CewMapper mapper) {
        this.mapper = mapper;
    }

    public List<CewDto> findAll() {
        return mapper.findAll();
    }

    public CewDto findByLoginId(String loginId) {
        return mapper.findByLoginId(loginId);
    }

    public void insert(CewDto cew) {
        mapper.insert(cew);
    }

    public void update(CewDto cew) {
        mapper.update(cew);
    }

    public void delete(String userId) {
        mapper.delete(userId);
    }
}
