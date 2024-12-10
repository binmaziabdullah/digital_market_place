package com.example.dmp.digital_course_marketplace.controller

import com.example.dmp.digital_course_marketplace.entity.*
import com.example.dmp.digital_course_marketplace.service.UserService
import com.example.dmp.jwt_auth.service.AuthenticationService
import com.example.dmp.jwt_auth.service.JwtUtil
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UsersController(
    private val service: UserService,
    private val authenticationManager: AuthenticationManager,
    private val authenticationService: AuthenticationService,
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/login")
    fun authenticateUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<*> {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginRequest.email,
                loginRequest.password
            )
        )
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails: UserDetails = authenticationService.loadUserByUsername(loginRequest.email)!!
        val jwt = jwtUtil.generateToken(userDetails)
        val responseBody = AuthenticationResponse(loginRequest.email, jwt)
        val responseHeaders = HttpHeaders()
        responseHeaders.add("Authorization", jwt)
        return ResponseEntity.ok().headers(responseHeaders).body(responseBody)
    }

    @PostMapping("/signup")
    fun saveUser(@RequestBody dto: CreateUsersDTO): ResponseEntity<UsersDto> {
        return ResponseEntity.ok(service.save(dto))
    }

    @GetMapping()
    fun findAll(): ResponseEntity<List<UsersDto>> {
        return ResponseEntity.ok(service.findAllByRoleIn())
    }


}