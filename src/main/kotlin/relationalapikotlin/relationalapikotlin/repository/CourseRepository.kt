package relationalapikotlin.relationalapikotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import relationalapikotlin.relationalapikotlin.entity.Course

interface CourseRepository: JpaRepository<Course, Long>