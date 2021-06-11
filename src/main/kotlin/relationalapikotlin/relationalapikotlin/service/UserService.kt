package relationalapikotlin.relationalapikotlin.service

import relationalapikotlin.relationalapikotlin.model.RegisterRequest
import relationalapikotlin.relationalapikotlin.model.RegisterResponse

interface UserService {
    fun register (registerRequest: RegisterRequest): RegisterResponse
}