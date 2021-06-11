package relationalapikotlin.relationalapikotlin.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import relationalapikotlin.relationalapikotlin.model.RegisterRequest
import relationalapikotlin.relationalapikotlin.model.RegisterResponse
import relationalapikotlin.relationalapikotlin.model.WebResponse
import relationalapikotlin.relationalapikotlin.service.UserService

@RestController
class UserController(val userService: UserService) {
    @PostMapping(
        value = ["/api/register"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun registerUser(@RequestBody registerRequest: RegisterRequest ): WebResponse<RegisterResponse> {
        val registerResponse = userService.register(registerRequest)

        return WebResponse(
            code = 201,
            status = "OK",
            data = registerResponse
        )
    }
}