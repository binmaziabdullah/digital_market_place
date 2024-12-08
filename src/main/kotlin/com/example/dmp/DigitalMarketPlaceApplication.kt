package com.example.dmp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@SpringBootApplication
class DigitalMarketPlaceApplication

fun main(args: Array<String>) {
	runApplication<DigitalMarketPlaceApplication>(*args)
}
