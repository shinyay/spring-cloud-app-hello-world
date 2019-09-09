package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Article
import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DummyDataGenerator {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {

        val syanagihara = userRepository.save(User("syanagihara", "Shinya", "Yanagihara"))
        articleRepository.save(Article(
                title = "Hello World",
                headline = "Hello Spring with Kotlin",
                content = "This application is build by Spring and Kotlin.",
                author = syanagihara
        ))
        articleRepository.save(Article(
                title = "タイトル",
                headline = "ヘッドライン",
                content = "コンテンツ",
                author = syanagihara
        ))
    }
}