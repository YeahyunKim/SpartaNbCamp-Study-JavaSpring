package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api") // api로 시작되는 호출은 HelloController로 넘어옴
public class HelloController {
    @GetMapping("/api/hello")
    @ResponseBody //순수하게 문자열을 반환하려면 @ResponseBody를 적으면 된다. 적지 않으면 html을 반환한다.
    public String hello() {
        return "Hello World2";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "Get Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "Post Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "Put Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "Delete Method 요청";
    }
}
