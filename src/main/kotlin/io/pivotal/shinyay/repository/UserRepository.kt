package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}