package com.example.dmp.digital_course_marketplace.service

import com.example.dmp.digital_course_marketplace.entity.BoughtCoursesDTO
import com.example.dmp.digital_course_marketplace.entity.CoursesDto
import com.example.dmp.digital_course_marketplace.entity.CreateCoursesDTO
import com.example.dmp.digital_course_marketplace.repository.CoursesRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CoursesService(
    private val repository: CoursesRepository,
    private val userService: UserService
) {

    fun save(dto: CreateCoursesDTO): CoursesDto {
        return repository.save(dto.toEntity(userService.getLoggedInUserId())).toDTO()
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