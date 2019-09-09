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
                title = "Title #1",
                headline = "This is a Headline text",
                content = "This is a content.",
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