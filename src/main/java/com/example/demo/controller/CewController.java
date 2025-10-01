package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.CewService;

@Controller
public class CewController {
    private final CewService service;

    public CewController(CewService service) {
        this.service = service;
    }

    // 메인 인덱스 → 로그인 페이지로 리다이렉트
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        return "layout/index";
    }

    @GetMapping("/policy")
    public String policy(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/policy :: content"); 
        return "layout/index";
    }

    // 탐지 로그
    @GetMapping("/detect-log")
    public String detectLog(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/detect-log :: *");
        return "layout/index";
    }

    // 알림 로그
    @GetMapping("/alert-log")
    public String alertLog(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/alert-log :: *");
        return "layout/index";
    }

    // 차단 이력 로그
    @GetMapping("/block-log")
    public String blockLog(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/block-log :: *");
        return "layout/index";
    }

    // 관리자 페이지
    @GetMapping("/admin")
    public String admin(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/admin :: *");
        return "layout/index";
    }

    // 시스템 환경 설정
    @GetMapping("/settings")
    public String settings(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("content", "pages/settings :: *");
        return "layout/index";
    }
}


