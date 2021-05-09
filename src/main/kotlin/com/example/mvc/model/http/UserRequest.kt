package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) // ->case by case 자동으로 스네이크케이스로 받아진다.
class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8) // 길이
    var name: String? = null,

    @field:PositiveOrZero // 0 <=  양수를 검증
    var age: Int? = null,
    @field:NotBlank // 공백 X
    var address: String? = null,

    @field:Email // email양식 검증
    var email: String? = null,

    // @JsonProperty(value = "phone_number") -> 일일이 설정하려면 힘들다!
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규식
    var phoneNumber:String? = null,

    var createdAt:String? = null, // yyyy-MM-dd HH:mm:ss
    ){
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss")
    private fun isValidCreatedAt():Boolean{

        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e:Exception){
            false
        }
    }
}