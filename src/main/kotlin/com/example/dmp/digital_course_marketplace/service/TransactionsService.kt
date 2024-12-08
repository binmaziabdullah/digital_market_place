package com.example.dmp.digital_course_marketplace.service

import com.example.dmp.digital_course_marketplace.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionsService(private val repository: TransactionRepository) {
}