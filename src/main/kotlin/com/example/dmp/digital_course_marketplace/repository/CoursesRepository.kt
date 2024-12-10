package com.example.dmp.digital_course_marketplace.repository

import com.example.dmp.digital_course_marketplace.entity.BoughtCoursesDTO
import com.example.dmp.digital_course_marketplace.entity.Courses
import com.example.dmp.digital_course_marketplace.entity.CoursesDto
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface CoursesRepository : CrudRepository<Courses, Long> {

    @Query(
        """select *
           from courses course
           where course.created_by_id = :loggedInUserId;
        """
    )
    fun findAllByLoggedInUser(loggedInUserId: Long): List<CoursesDto>

    @Query(
        """select *
            from courses course
            where if(:title is not null, course.title = :title, true)
            and if(:description is not null, course.description = :description, true);             
        """
    )
    fun findAllCourseByTileOrDescription(title: String?, description: String?): List<CoursesDto>

    @Query(
        """SELECT c.id   AS course_id,
           c.title       AS course_name,
           SUM(c.price)  AS total_amount
    FROM transactions t
             JOIN courses c ON t.course_id = c.id
    WHERE t.purchase_date BETWEEN :startDate AND :endDate
    GROUP BY c.id, c.title;
        """
    )
    fun findAllBoughtCourses(startDate: LocalDate, endDate: LocalDate): List<BoughtCoursesDTO>
}