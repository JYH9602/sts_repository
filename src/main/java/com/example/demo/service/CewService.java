package com.example.demo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CewDao;
import com.example.demo.dto.CewDto;

@Service
public class CewService {
    private final CewDao dao;

    public CewService(CewDao dao) {
        this.dao = dao;
    }

    public List<CewDto> getAll() {
        return dao.findAll();
    }

    public CewDto getByLoginId(String loginId) {
        return dao.findByLoginId(loginId);
    }

    public void add(CewDto cew) {
        dao.insert(cew);
    }

    public void modify(CewDto cew) {
        dao.update(cew);
    }

    public void remove(String userId) {
        dao.delete(userId);
    }

    // ✅ 로그인 기능
    public CewDto login(String loginId, String password) {
    	
        CewDto user = dao.findByLoginId(loginId);
        
        // 로그인 id로 database에서 가져온 암호화 된 비밀번호와 사용자가 입력한 비밀번호가 같은지 체크
        // >> encoder.matches 함수.
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Boolean result = encoder.matches(password, user.getPassword());
        
        
        if (user != null && result) {
            return user;
        }
        return null;
    }
    
    
    
    
}

