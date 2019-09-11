package io.pivotal.shinyay

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.pivotal.shinyay.entity.Article
import io.pivotal.shinyay.entity.User
import io.pivotal.shinyay.repository.ArticleRepository
import io.pivotal.shinyay.repository.UserRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest(@Autowired val mockMvc: MockMvc) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @MockkBean
    lateinit var userRepository: UserRepository

    @MockkBean
    lateinit var  articleRepository: ArticleRepository

    lateinit var syanagihara: User
    lateinit var shinyay: User
    lateinit var pivotal: Article
    lateinit var vmware: Article

    @BeforeAll
    fun initialize() {
        logger.info(">> Setup for Integration Test")
        syanagihara = User("syanagihara", "Shinya", "Yanagihara")
        shinyay = User("shinyay", "Shinya", "Yanagihara")
        pivotal = Article("Pivotal", "Do the right thing", "We Transform How The World Builds Software.", syanagihara)
        vmware = Article("VMware", "VMware aquires Pivotal", "VMware Leveraged Kubernetes For Its Cloud-Native", shinyay)
    }

    @Test
    fun given_when_then() {
        logger.info("GIVEN: Preparation -> The state is X")
        logger.info("WHEN: Execution -> Something happens")
        logger.info("THEN: Verification -> The result is Y")
    }

    @Test
    fun givenUsers_whenAccessHttpApiEndpoint_thenReturnOkStatus() {

        every { userRepository.findAll() } returns listOf(syanagihara, shinyay)

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/user")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
    }

    @Test
    fun givenUsers_whenAccessHttpApiEndpoint_thenReturnAllUsersSingle() {

        every { userRepository.findAll() } returns listOf(syanagihara)

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[0].login").value(syanagihara.login))
    }

    @Test
    fun givenUsers_whenAccessHttpApiEndpoint_thenReturnAllUsersMulti() {

        every { userRepository.findAll() } returns listOf(syanagihara, shinyay)

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[0].login").value(syanagihara.login))
                .andExpect(jsonPath("$.[1].login").value(shinyay.login))
    }

    @Test
    fun givenUsersAndArticles_whenAccessHttpApiEndpoint_thenReturnOkStatus() {

        every { articleRepository.findAllByOrderByAddedAtDesc() } returns listOf(pivotal, vmware)

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/article")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }

}