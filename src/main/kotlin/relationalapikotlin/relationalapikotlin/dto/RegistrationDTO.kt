package relationalapikotlin.relationalapikotlin.dto

import relationalapikotlin.relationalapikotlin.entity.Course
import relationalapikotlin.relationalapikotlin.entity.User
import java.util.*

data class RegistrationDTO(
    val id: Long?,
    val user: User?,
    val course: Course?,
    var registeredAt: Date?
)