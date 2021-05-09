package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        return UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "~~~~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.address = "b"
                this.email = "c"
                this.phoneNumber = "11111111111"
            })

            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.address = "b.address"
                this.email = "c.email"
                this.phoneNumber = "11111112222"
            })
        }
    }
}