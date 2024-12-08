package com.example.dmp.digital_course_marketplace.controller

import com.example.dmp.digital_course_marketplace.service.TransactionsService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/digital-course-market-place/transactions")
class TransactionsController(private val service: TransactionsService) {


}