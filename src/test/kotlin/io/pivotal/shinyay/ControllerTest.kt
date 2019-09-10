package io.pivotal.shinyay

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class ControllerTest(@Autowired val mockMvc: MockMvc) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @MockkBean
    lateinit var userRepository: UserRepository

    @MockkBean
    lateinit var  articleRepository: ArticleRepository

    @Test
    fun given_when_then() {
        logger.info("GIVEN: Preparation -> The state is X")
        logger.info("WHEN: Execution -> Something happens")
        logger.info("THEN: Verification -> The result is Y")
    }

}