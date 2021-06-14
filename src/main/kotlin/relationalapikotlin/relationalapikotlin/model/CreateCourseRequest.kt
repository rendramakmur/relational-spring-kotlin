package relationalapikotlin.relationalapikotlin.model

import org.hibernate.validator.constraints.URL
import javax.validation.constraints.NotBlank

data class CreateCourseRequest (
    @field:NotBlank
    val category: String,

    @field: NotBlank
    val title: String,

    @field: NotBlank
    @field: URL
    val url: String
    )