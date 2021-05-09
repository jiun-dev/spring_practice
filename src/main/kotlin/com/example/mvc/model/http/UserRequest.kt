package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) // ->case by case 자동으로 스네이크케이스로 받아진다.
class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var address: String? = null,
    var email: String? = null,

    // @JsonProperty(value = "phone_number") -> 일일이 설정하려면 힘들다!
    var phoneNumber:String? = null,
    )