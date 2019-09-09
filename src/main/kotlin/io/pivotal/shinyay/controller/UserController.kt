package io.pivotal.shinyay.controller

import io.pivotal.shinyay.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(val repository: UserRepository) {

    @GetMapping("/user")
    fun findAll() = repository.findAll()

    @GetMapping("/user/{login}")
    fun findOne(@PathVariable login: String) = repository.findByLogin(login)
}