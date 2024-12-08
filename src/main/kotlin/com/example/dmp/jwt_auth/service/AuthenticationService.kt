package com.example.dmp.jwt_auth.service

import com.example.dmp.digital_course_marketplace.repository.UsersRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class AuthenticationService(private val repository: UsersRepository? = null) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails? {
        val user = repository!!.findByEmail(email)
        return org.springframework.security.core.userdetails.User(user?.email, user?.password, ArrayList())
    }



}