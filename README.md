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

### Mock Test

- [Mokk](https://mockk.io/)
  - [SpringMockK](https://github.com/Ninja-Squad/springmockk)
    - Support for Spring Boot integration tests written in Kotlin using MockK instead of Mockito
- [Mockito](https://site.mockito.org)

### MockK

- [HowTo](https://mockk.io/)

```
val car = mockk<Car>()
every { car.drive(Direction.NORTH) } returns Outcome.OK
car.drive(Direction.NORTH) // returns OK
verify { car.drive(Direction.NORTH) }
confirmVerified(car)
```

- `val car = mockk<Car>()`
  - Create Mock Instance

- `every { car.drive(Direction.NORTH) } returns Outcome.OK`
  - Pattern for Mock Instance
    - Whenever car instance call drive function with Direction.NORTH parameter, it returns Outcome.OK

- `car.drive(Direction.NORTH)`
  - Actually call car drive function

- `verify { car.drive(Direction.NORTH) }`
  - Check for call function

- `confirmVerified(car)`
  - Confirm all verify function for verification

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
