package relationalapikotlin.relationalapikotlin.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import relationalapikotlin.relationalapikotlin.dto.RegistrationDTO
import relationalapikotlin.relationalapikotlin.entity.Course
import relationalapikotlin.relationalapikotlin.exception.NotFoundException
import relationalapikotlin.relationalapikotlin.model.*
import relationalapikotlin.relationalapikotlin.repository.CourseRepository
import relationalapikotlin.relationalapikotlin.validate.ValidationUtil
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class CourseServiceImpl(
    val courseRepository: CourseRepository,
    val validationUtil: ValidationUtil
    ): CourseService {

    override fun createCourse(createCourseRequest: CreateCourseRequest): CourseResponse {
        validationUtil.validate(createCourseRequest)

        val course = Course(
            category = createCourseRequest.category,
            title = createCourseRequest.title,
            url = createCourseRequest.url,
            createdAt = Date()
        )

        courseRepository.save(course)

        return CourseResponse(
            id = course.id,
            category = course.category,
            title = course.title,
            url = course.url,
            createdAt = course.createdAt,
            updatedAt = course.updatedAt
        )
    }

    override fun updateCourse(id: Long, updateCourseRequest: UpdateCourseRequest): CourseResponse {
        validationUtil.validate(updateCourseRequest)

        val course = findByIdAndCheckExistance(id)

        course.apply {
            title = updateCourseRequest.title
            category = updateCourseRequest.category
            url = updateCourseRequest.url
            updatedAt = Date()
        }

        courseRepository.save(course)

        return CourseResponse(
            id = course.id,
            title = course.title,
            category = course.category,
            url = course.url,
            createdAt = course.createdAt,
            updatedAt = course.updatedAt
        )
    }

    override fun getCourseById(id: Long): CourseRegistrationResponse {
        val course = findByIdAndCheckExistance(id)
//        val registrationsDto: ArrayList<RegistrationDTO> = ArrayList()
//        course.registrations?.forEach {
//            var registrationDto = RegistrationDTO(
//                id = it.id,
////                course = it.course,
////                user = it.user,
//                registeredAt = it.registeredAt
//            )
//
//            registrationsDto.add(registrationDto)
//        }
        course.registrations?.forEach {
            println(it.id.toString())
        }

        return CourseRegistrationResponse(
            id = course.id,
            title = course.title,
            category = course.category,
            url = course.url,
            createdAt = course.createdAt,
            updatedAt = course.updatedAt,
            registrations = null
        )
    }

    override fun listOfCourse(listCourseRequest: ListCourseRequest): List<CourseResponse> {
        val listOfCoursePage = courseRepository.findAll(PageRequest.of(listCourseRequest.page, listCourseRequest.size))
        println(listOfCoursePage)
        val courses: List<Course> = listOfCoursePage.get().collect(Collectors.toList())
        return courses.map {
            CourseResponse(
                id = it.id,
                title = it. title,
                category = it.category,
                url = it.url,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    private fun findByIdAndCheckExistance(id: Long): Course {
        val course = courseRepository.findByIdOrNull(id)

        if (course == null) {
            throw NotFoundException()
        } else {
            return course
        }
    }
}