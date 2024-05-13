package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 1;

    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    } //url을 탐색

    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    } //경로를 탐색

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    } // 타임리프를 통해 response

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }
}
