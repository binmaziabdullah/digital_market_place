package com.example.dmp.digital_course_marketplace.entity

import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("courses")
data class Courses(
    @Id
    val id: Long? = null,
    val createdById: Long?,
    val title: String,
    val description: String,
    val price: Double
) {
    fun toDTO(): CoursesDto {
        return CoursesDto(
            id = id!!,
            createdById = createdById,
            title = title,
            description = description,
            price = price
        )
    }
}


data class CreateCoursesDTO(
    @field:NotNull var title: String,
    @field:NotNull val description: String,
    @field:NotNull val price: Double
) {
    fun toEntity(createdById: Long): Courses {
        return Courses(
            createdById = createdById,
            title = title,
            description = description,
            price = price
        )
    }
}

data class CoursesDto(
    val id: Long,
    val createdById: Long?,
    val title: String,
    val description: String,
    val price: Double
)

data class BoughtCoursesDTO(
    val courseId: Long,
    val courseName: String?,
    val totalAmount: Double
)