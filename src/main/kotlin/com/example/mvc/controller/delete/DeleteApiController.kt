package com.example.mvc.controller.delete

import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min

@RestController
@RequestMapping("/api")
@Validated // kotlin에서 java bin 유효성을 검증하기 위해
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @javax.validation.constraints.NotNull(message = "age값이 누락되었습니다.")
        @Min(value = 20, message = "20보다 커야됩니다.")
        @RequestParam _age: Int,
    ): String {
        println(_name)
        println(_age)

        return _name + " " + _age
    }
}