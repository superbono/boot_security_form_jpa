package com.form.security.controller;

import com.form.security.dto.UserDto;
import com.form.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Controller
    @AllArgsConstructor
    public class MemberController {
        private UserService service;

        // 메인 페이지
        @GetMapping("/")
        public String index() {
            return "/index";
        }

        // 회원가입 페이지
        @GetMapping("/member/regist")
        public String dispSignup() {
            return "/user/regist";
        }

        // 회원가입 처리
        @PostMapping("/member/regist")
        public String execSignup(UserDto dto) {
            service.join(dto);

            return "redirect:/member/login";
        }

        // 로그인 페이지
        @GetMapping("/member/login")
        public String dispLogin() {
            return "user/login";
        }

        // 로그인 결과 페이지
//        @GetMapping("/user/login/result")
//        public String dispLoginResult() {
//            return "/loginSuccess";
//        }

        // 로그아웃 결과 페이지
//        @GetMapping("/user/logout/result")
//        public String dispLogout() {
//            return "/logout";
//        }

        // 접근 거부 페이지
        @GetMapping("/user/denied")
        public String dispDenied() {
            return "/denied";
        }

        // 내 정보 페이지
        @GetMapping("/user/info")
        public String dispMyInfo() {
            return "user/info";
        }

        // 어드민 페이지
        @GetMapping("/admin")
        public String dispAdmin() {
            return "/admin";
        }
    }

}
