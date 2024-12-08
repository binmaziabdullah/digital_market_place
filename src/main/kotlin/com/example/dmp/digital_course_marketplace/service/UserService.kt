package com.example.dmp.digital_course_marketplace.service

import com.example.dmp.digital_course_marketplace.entity.CreateUsersDTO
import com.example.dmp.digital_course_marketplace.entity.UsersDto
import com.example.dmp.digital_course_marketplace.repository.UsersRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val repository: UsersRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun save(dto: CreateUsersDTO): UsersDto {
        dto.password = passwordEncoder.encode(dto.password)
        return repository.save(dto.toEntity()).toDTO()
    }

    fun findAllByRoleIn(): List<UsersDto> {
        return repository.findAllByRoleIn()
    }

    fun getLoggedInUserId(): Long {
        val authentication = SecurityContextHolder.getContext().authentication
        val userEmail = authentication.name
        val userEntity = repository.findByEmail(userEmail)
        return userEntity?.id!!
    }


}