package io.pivotal.shinyay

import com.ninjasquad.springmockk.MockkBean
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class ControllerTest(val mockMvc: MockMvc) {

    @MockkBean
    lateinit var userRepository: UserRepository

    @MockkBean
    lateinit var  articleRepository: ArticleRepository
}