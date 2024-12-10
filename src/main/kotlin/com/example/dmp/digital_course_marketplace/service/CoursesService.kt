package com.example.dmp.digital_course_marketplace.service

import com.example.dmp.digital_course_marketplace.entity.*
import com.example.dmp.digital_course_marketplace.repository.CoursesRepository
import com.example.dmp.exception_handling.AlreadyPurchasedException
import com.example.dmp.exception_handling.CourseNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CoursesService(
    private val repository: CoursesRepository,
    private val userService: UserService,
    private val transactionsService: TransactionsService
) {

    fun save(dto: CreateCoursesDTO): CoursesDto {
        return repository.save(dto.toEntity(userService.getLoggedInUserId())).toDTO()
    }

    fun buyCourse(courseId: Long): Transactions {
        val loggedInUserId = userService.getLoggedInUserId()
        repository.findById(courseId)
            .orElseThrow { CourseNotFoundException("Course not found") }

        if (transactionsService.findExistingBoughtCourseByCourseAndUser(courseId, loggedInUserId))
            throw AlreadyPurchasedException("You already own this course")

        val transactions = Transactions(courseId = courseId, userId = loggedInUserId, purchaseDate = LocalDate.now())
        return transactionsService.save(transactions)
    }

    fun findAllByLoggedInUser(loggedInUserId: Long): List<CoursesDto> {
        return repository.findAllByLoggedInUser(loggedInUserId)
    }

    fun findAllCourseByTileOrDescription(title: String?, description: String?): List<CoursesDto> {
        return repository.findAllCourseByTileOrDescription(title, description)
    }

    fun findAllBoughtCourses(startDate: LocalDate, endDate: LocalDate): List<BoughtCoursesDTO> {
        return repository.findAllBoughtCourses(startDate, endDate)
    }
}