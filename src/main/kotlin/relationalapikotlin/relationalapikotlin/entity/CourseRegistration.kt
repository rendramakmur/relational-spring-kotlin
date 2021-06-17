package relationalapikotlin.relationalapikotlin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "course_registration")
data class CourseRegistration (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User? = null,

    @ManyToOne
    @JoinColumn(name = "course_id")
    val course: Course? = null,

    @Column(name = "registered_at")
    var registeredAt: Date? = null
)