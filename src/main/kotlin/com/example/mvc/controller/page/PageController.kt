package com.example.mvc.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller // ->static 폴더 하위에 있는 리턴값 파일을 찾는다.
class PageController {

    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }
    @ResponseBody // -> RestController랑 같이 써야할때
    @GetMapping("/test")
    fun response(): String {
        return "main.html"
    }

}