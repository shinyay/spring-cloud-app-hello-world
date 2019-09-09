package io.pivotal.shinyay.controller

import io.pivotal.shinyay.repository.ArticleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController(val repository: ArticleRepository) {

    @GetMapping
    fun findAll() = repository.findAllByOrderByAddedAtDesc()
}