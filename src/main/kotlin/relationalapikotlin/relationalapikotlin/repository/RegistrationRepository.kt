package relationalapikotlin.relationalapikotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import relationalapikotlin.relationalapikotlin.entity.CourseRegistration

interface RegistrationRepository: JpaRepository<CourseRegistration, Long>