package io.pivotal.shinyay

import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoryTest (
        val entityManager: TestEntityManager,
        val userRepository: UserRepository) {

    @Test
    fun givenUser_whenFindByLogin_thenReturnUser() {
        val shinyay = User("shinyay", "Shinya", "Yanagihara")
        entityManager.persistAndFlush(shinyay)
        val actualUser = userRepository.findByLogin(shinyay.login)
        assertThat(actualUser).isEqualTo(shinyay)
    }
}