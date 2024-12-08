package com.example.dmp.digital_course_marketplace.entity

import com.example.dmp.digital_course_marketplace.role_enum.UserRole
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
data class Users(
    @Id
    val id: Long? = null,
    val email: String,
    val password: String,
    val role: UserRole = UserRole.ADMIN
) {
    fun toDTO(): UsersDto {
        return UsersDto(
            id = id!!,
            email = email,
            password = password,
            role = role
        )
    }
}

data class CreateUsersDTO(
    @field:NotNull val email: String,
    @field:NotNull var password: String,
    @field:NotNull val role: UserRole
) {
    fun toEntity(): Users {
        return Users(
            email = email,
            password = password,
            role = role
        )
    }
}

data class UsersDto(
    val id: Long,
    val email: String,
    val password: String,
    val role: UserRole
)

data class AuthenticationRequest(
    var username: String,
    var password: String
)

data class AuthenticationResponse(
    var username: String,
    var token:String
)

data class LoginRequest(
    var email: String,
    var password: String
)

data class SignUpRequest(
    var email: String,
    var password: String
)

data class ApiResponse(
    var success: Boolean,
    var message:String
)