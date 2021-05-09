package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // Rest Api Controller 동작 -> return type이 object이면 json으로 바뀜
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    @GetMapping("/hello") // Get http://localhost:8080/api/hello
    fun hello() :String{
        return "Hello World"
    }
    @RequestMapping(method = [RequestMethod.GET],path = ["/request-mapping"])
    fun requestMapping(): String {
        return "Mapping"
    }
    @GetMapping("/get-mapping/path-variable/{name}/{age}") // Get http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable(@PathVariable name: String ,@PathVariable age: Int): String{
        // 형변환 에러 주의!
        println("${name}, ${age}")
        return name + " " + age
    }
    // 변수 이름을 다르게 주어야 할 때!
    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // Get http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable2(@PathVariable(value = "name") _name: String ,@PathVariable age: Int): String{
        val name = "Kotlin"
        println("${_name}, ${age}")
        return name + " " + age
    }

    // Query Parameters  http://localhost:8080/api/pages?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param")
    fun queryParams(
        @RequestParam name: String,
        @RequestParam (value = "age") age: Int
    ):String {
        println("${name}, ${age}")
        return name + " " + age
    }

    // class를 인자로 받는 방법
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // map 으로 받는 방법
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }
}