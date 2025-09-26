package com.example.demo.controller;

import com.example.demo.dto.CewDto;
import com.example.demo.service.CewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final CewService service;

    public LoginController(CewService service) {
        this.service = service;
    }

    // 로그인 페이지 GET
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
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
            // 세션에 로그인 정보 저장
            session.setAttribute("user", user);

            // 대시보드로 리다이렉트
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login"; // 실패 시 로그인 페이지 다시
        }
    }

    // 대시보드 GET
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        CewDto user = (CewDto) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // 로그인 안했으면 로그인 페이지로
        }

        model.addAttribute("user", user);
        return "dashboard"; // templates/dashboard.html
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기
        return "redirect:/login";
    }
}