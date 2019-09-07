package io.pivotal.shinyay

import org.junit.jupiter.api.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringCloudAppHelloWorldApplicationTests {

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
	fun contextLoads() {
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
