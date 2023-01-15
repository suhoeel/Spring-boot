package com.suho

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
//@ComponentScan(basePackages = ["com.suho"])
//@EnableAutoConfiguration
//@Configuration
@RestController
@RequestMapping("/api/v1/customers")
class Main {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    /*@GetMapping("/")
    fun greet(): GreetResponse {
        return GreetResponse("hello", listOf("java", "kotlin", "c++"), Person("suho", 20, 20000.0))
    }

    data class Person(val name: String, val age: Int, val price: Double)
    data class GreetResponse(val greet: String, val favorites: List<String>, val person: Person)*/

    @GetMapping
    fun getCustomers(): List<Customer> {
        return customerRepository.findAll()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java, *args)
}


