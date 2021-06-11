package relationalapikotlin.relationalapikotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import relationalapikotlin.relationalapikotlin.entity.User

interface UserRepository: JpaRepository<User, Long>