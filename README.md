# Spring Cloud Application with Eureka

Overview

## Description

### JUnit 5

```
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "junit")
		exclude(module = "mockito-core")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
```

|Dependency|Function|
|----------|--------|
|junit-jupiter-api|Test Description: annotation and assertion(like assertEquals/assertTrue)|
|junit-jupiter-params|Test Description: parameterized test|
|junit-jupiter-engine|Test Exectuion|
|assertj-core|Test Description: assertThat/Matcher|
|junit-vintage-engine|Test Exectuion as JUnit3/JUnit4|

#### Tips: Secondary Constructor for JPATest
```
@DataJpaTest
class RepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository)
```

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
