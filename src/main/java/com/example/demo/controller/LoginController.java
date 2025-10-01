package com.example.demo.controller;

import com.example.demo.dto.CewDto;
import com.example.demo.service.CewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final CewService service;

    public LoginController(CewService service) {
        this.service = service;
    }

    // 로그인 페이지 GET
    @GetMapping("/login")
    public String loginPage() {
        return "login/login"; // templates/login/login.html
    }

    // 로그인 처리 POST
    @PostMapping("/login")
    public String login(
            @RequestParam("login_id") String loginId,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        CewDto user = service.login(loginId, password);

        if (user != null) {
            // 세션 저장
            session.setAttribute("user", user);

            // 로그인 성공 → 대시보드로
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login/login"; // 실패 시 다시 로그인 페이지
        }
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
