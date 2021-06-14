package relationalapikotlin.relationalapikotlin.model

import relationalapikotlin.relationalapikotlin.dto.RegistrationDTO
import java.util.*

data class CourseRegistrationResponse(
    val id: Long?,
    val category: String?,
    val title: String?,
    val url: String?,
    val createdAt: Date?,
    val updatedAt: Date?,
    val registrations: List<RegistrationDTO>?
)