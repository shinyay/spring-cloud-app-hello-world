package io.pivotal.shinyay

import io.pivotal.shinyay.entity.Article
import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository) {

    @Test
    fun givenUser_whenFindByLogin_thenReturnUser() {
        val shinyay = User("shinyay", "Shinya", "Yanagihara")
        entityManager.persistAndFlush(shinyay)
        val actualUser = userRepository.findByLogin(shinyay.login)
        assertThat(actualUser).isEqualTo(shinyay)
    }

    @Test
    fun givenUserAndArticle_whenFindByIdOrNull_thenReturnArticle() {
        val shinyay = User("shinyay", "Shinya", "Yanaihara")
        entityManager.persist(shinyay)
        val article = Article(
                "Hello Spring",
                "Spring with Kotlin",
                "https://github.com/shinyay/spring-cloud-app-hello-world",
                shinyay)
        entityManager.persist(article)
        entityManager.flush()
        val actualArticle = articleRepository.findByIdOrNull(article.id!!)
        assertThat(actualArticle).isEqualTo(article)
    }
}