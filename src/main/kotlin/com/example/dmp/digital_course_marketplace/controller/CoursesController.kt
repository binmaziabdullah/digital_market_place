package com.example.dmp.digital_course_marketplace.controller

import com.example.dmp.digital_course_marketplace.entity.*
import com.example.dmp.digital_course_marketplace.service.CoursesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/course")
class CoursesController(private val service: CoursesService) {

    @PostMapping()
    fun saveCourse(@RequestBody dto: CreateCoursesDTO): ResponseEntity<CoursesDto> {
        return ResponseEntity.ok(service.save(dto))
    }

    @GetMapping("/buy-course/{id}")
    fun buyCourse(@PathVariable id: Long): ResponseEntity<Transactions> {
        return ResponseEntity.ok(service.buyCourse(id))
    }

    @GetMapping("/{loggedInUserId}")
    fun findAllByLoggedInUser(@PathVariable loggedInUserId: Long): ResponseEntity<List<CoursesDto>> {
        return ResponseEntity.ok(service.findAllByLoggedInUser(loggedInUserId))
    }

    @GetMapping("/available-course")
    fun findAllCourseByTileOrDescription(
        @RequestParam(required = false) title: String?,
        @RequestParam(required = false) description: String?
    ): ResponseEntity<List<CoursesDto>> {
        return ResponseEntity.ok(service.findAllCourseByTileOrDescription(title, description))
    }

    @GetMapping("/all-bought-course")
    fun findAllBoughtCourses(
        @RequestParam(required = false) startDate: LocalDate,
        @RequestParam(required = false) endDate: LocalDate
    ): ResponseEntity<List<BoughtCoursesDTO>> {
        return ResponseEntity.ok(service.findAllBoughtCourses(startDate, endDate))
    }
}