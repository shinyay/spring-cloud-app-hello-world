package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Article
import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.extensions.format
import io.pivotal.shinyay.repository.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController(val repository: ArticleRepository) {

    @GetMapping("/")
    fun html(model: Model): String {
        model["title"] = "Hello"
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "hello"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository
                .findBySlug(slug)
                ?.render()
                ?: throw IllegalArgumentException("Wrong Slug")
        model["title"] = article.title
        model["article"] = article

        return "article"
    }

    data class RenderedArticle(
            val slug: String,
            val title: String,
            val headline: String,
            val content: String,
            val author: User,
            val addedAt: String)

    fun Article.render() = RenderedArticle(
            slug,
            title,
            headline,
            content,
            author,
            addedAt.format()
    )
}