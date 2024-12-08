package com.example.dmp.digital_course_marketplace.repository

import com.example.dmp.digital_course_marketplace.entity.Users
import com.example.dmp.digital_course_marketplace.entity.UsersDto
import com.example.dmp.digital_course_marketplace.role_enum.UserRole
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : CrudRepository<Users, Long> {
    fun findByEmail(email: String): Users?

    fun findAllByRoleIn(roles: List<UserRole> = listOf(UserRole.CUSTOMER, UserRole.CREATOR)): List<UsersDto>
}