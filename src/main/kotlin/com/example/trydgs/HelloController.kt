package com.example.trydgs

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HelloController {
    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }
}