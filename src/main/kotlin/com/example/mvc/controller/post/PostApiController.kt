package com.example.mvc.controller.post

import org.springframework.web.bind.annotation.*
import com.example.mvc.model.http.UserRequest as UserRequest

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        print(userRequest)
        return userRequest
    }
}