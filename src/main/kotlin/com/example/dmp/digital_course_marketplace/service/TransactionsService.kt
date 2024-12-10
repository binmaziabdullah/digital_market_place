package com.example.dmp.digital_course_marketplace.service

import com.example.dmp.digital_course_marketplace.entity.Transactions
import com.example.dmp.digital_course_marketplace.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionsService(private val repository: TransactionRepository) {

    fun save(transactions: Transactions): Transactions {
        return repository.save(transactions)
    }

    fun findExistingBoughtCourseByCourseAndUser(courseId: Long, userId: Long): Boolean {
        return repository.existsByCourseIdAndUserId(courseId, userId)
    }
}