package com.form.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    public String main() {
        return "index";
    }

    @RequestMapping("/member/regist")
    public String join() {
        return "user/regist";
    }

    @RequestMapping("member/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("user/info/{id}")
    public String info(@PathVariable Long id) {
        return "user/info";
    }

    @RequestMapping("user/info/edit/{id}")
    public String update(@PathVariable Long id) {
        return "user/edit";
    }

    @RequestMapping("user/info/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "user/delete";
    }

}
