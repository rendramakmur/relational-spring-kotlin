package relationalapikotlin.relationalapikotlin.service

import relationalapikotlin.relationalapikotlin.model.*

interface CourseService {
    fun createCourse(createCourseRequest: CreateCourseRequest): CourseResponse

    fun updateCourse(id: Long, updateCourseRequest: UpdateCourseRequest): CourseResponse

    fun getCourseById(id: Long): CourseResponse

    fun listOfCourse(listCourseRequest: ListCourseRequest): List<CourseResponse>
}