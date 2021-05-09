package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {
            if (it < 20) {
                return ResponseEntity.status(400).body("age가 20이하입니다.")
            }
            return ResponseEntity.ok("정상")
        } ?: kotlin.run {
            return ResponseEntity.status(400).body(" age값이 누락되었습니다.")
        }

//        if (age == null) {
//            return ResponseEntity.status(400).body(" age값이 누락되었습니다.")
//        }
//        if (age < 20) {
//            return ResponseEntity.status(400).body("age가 20이하입니다.")
//        }
        // return ResponseEntity.ok("정상")
    }
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }
}