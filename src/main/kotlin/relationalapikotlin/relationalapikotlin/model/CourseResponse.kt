package relationalapikotlin.relationalapikotlin.model

import java.util.*

data class CourseResponse(
    val id: Long?,
    val category: String?,
    val title: String?,
    val url: String?,
    val createdAt: Date?,
    val updatedAt: Date?
)