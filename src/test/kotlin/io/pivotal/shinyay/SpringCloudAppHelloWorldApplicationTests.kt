package io.pivotal.shinyay

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringCloudAppHelloWorldApplicationTests(@Autowired val restTemplate: TestRestTemplate) {

	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

	@BeforeAll
	fun initialize() {
		logger.info(">> Setup for Integration Test")
	}

	@BeforeEach
	fun beforeEach() {
		logger.info(">> Setup for Each Test")
	}

	@Test
	fun given_when_then() {
		logger.info("GIVEN: Preparation -> The state is X")
		logger.info("WHEN: Execution -> Something happens")
		logger.info("THEN: Verification -> The result is Y")
	}

	@Test
	fun httpClient_accessContextRoot_statusCodeOK() {
		val entity = restTemplate.getForEntity<String>("/")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
	}

	@AfterEach
	fun afterEach() {
		logger.info(">> Teardown for Each Test")
	}

	@AfterAll
	fun afterAll() {
		logger.info(">> Teardown for Integration Test")
	}
}
