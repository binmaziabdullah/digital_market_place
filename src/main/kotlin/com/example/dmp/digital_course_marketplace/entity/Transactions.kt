package com.example.dmp.digital_course_marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("transactions")
data class Transactions(
    @Id
    val id: Long? = null,
    val courseId: Long,
    val userId: Long,
    val purchaseDate: LocalDate = LocalDate.now()
)

data class TransactionsDto(
    val id: Long,
    val courseId: Long,
    val userId: String,
    val purchaseDate: LocalDate
)