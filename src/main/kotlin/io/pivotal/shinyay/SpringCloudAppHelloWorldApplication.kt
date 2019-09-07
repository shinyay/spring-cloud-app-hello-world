package io.pivotal.shinyay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudAppHelloWorldApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudAppHelloWorldApplication>(*args)
}
