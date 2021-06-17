package relationalapikotlin.relationalapikotlin.controller

import org.springframework.web.bind.annotation.*
import relationalapikotlin.relationalapikotlin.model.*
import relationalapikotlin.relationalapikotlin.service.CourseService

@RestController
class CourseController(val courseService: CourseService) {
    @PostMapping(
        value = ["/api/course"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createCourse(@RequestBody createCourseRequest: CreateCourseRequest): WebResponse<CourseResponse> {
        val createCourseResponse = courseService.createCourse(createCourseRequest)

        return WebResponse(
            code = 201,
            status = "OK",
            data = createCourseResponse
        )
    }

    @PutMapping(
        value = ["/api/course/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateCourse(
        @PathVariable("id")
        id: Long,
        @RequestBody
        updateCourseRequest: UpdateCourseRequest
    ): WebResponse<CourseResponse> {
        val updatedCourseResponse = courseService.updateCourse(id, updateCourseRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = updatedCourseResponse
        )
    }

    @GetMapping(
        value = ["/api/course/{id}"],
        produces = ["application/json"]
    )
    fun getCourseById(@PathVariable("id") id: Long): WebResponse<CourseRegistrationResponse> {
        val getCourseByIdResponse = courseService.getCourseById(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = getCourseByIdResponse
        )
    }

    @GetMapping(
        value = ["/api/courses"],
        produces = ["application/json"]
    )
    fun getListCourses(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ) : WebResponse<List<CourseResponse>> {
        val request = ListCourseRequest(page = page, size = size)
        val courses = courseService.listOfCourse(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = courses
        )
    }
}