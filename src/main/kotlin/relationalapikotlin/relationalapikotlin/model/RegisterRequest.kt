package relationalapikotlin.relationalapikotlin.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class RegisterRequest (
    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    val firstName: String,

    @field:NotBlank
    val lastName: String,

    @field:NotBlank
    val password: String
)