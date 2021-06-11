package relationalapikotlin.relationalapikotlin.service

import org.springframework.stereotype.Service
import relationalapikotlin.relationalapikotlin.entity.User
import relationalapikotlin.relationalapikotlin.model.RegisterRequest
import relationalapikotlin.relationalapikotlin.model.RegisterResponse
import relationalapikotlin.relationalapikotlin.repository.UserRepository
import java.util.*

@Service
class UserServiceImpl (val userRepository: UserRepository): UserService {
    override fun register(registerRequest: RegisterRequest): RegisterResponse {
        val user = User(
            email = registerRequest.email,
            firstName = registerRequest.firstName,
            lastName = registerRequest.lastName,
            password = registerRequest.password,
            createdAt = Date(),
            updatedAt = null
        )

        userRepository.save(user)

        return RegisterResponse(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}