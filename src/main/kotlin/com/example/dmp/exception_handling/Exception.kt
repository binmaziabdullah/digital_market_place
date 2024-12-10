package com.example.dmp.exception_handling

class CourseNotFoundException(message: String) : RuntimeException(message)

class AlreadyPurchasedException(message: String) : RuntimeException(message)