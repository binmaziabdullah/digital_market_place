package com.example.dmp.exception_handling

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {


    @ExceptionHandler(CourseNotFoundException::class)
    fun handleCourseNotFoundException(ex: CourseNotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(AlreadyPurchasedException::class)
    fun handleAlreadyPurchasedException(ex: AlreadyPurchasedException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }
}