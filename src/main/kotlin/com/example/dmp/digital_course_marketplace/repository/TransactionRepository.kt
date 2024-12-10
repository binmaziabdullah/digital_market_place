package com.example.dmp.digital_course_marketplace.repository

import com.example.dmp.digital_course_marketplace.entity.Transactions
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : CrudRepository<Transactions, Long> {

    fun existsByCourseIdAndUserId(courseId: Long, userId: Long): Boolean
}