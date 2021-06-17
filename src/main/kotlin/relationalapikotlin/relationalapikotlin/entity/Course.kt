package relationalapikotlin.relationalapikotlin.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "course")
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "url")
    var url: String? = null,

    @Column(name = "category")
    var category: String? = null,

    @Column(name = "created_at")
    @CreationTimestamp
    var createdAt: Date? = null,

    @Column(name = "updated_at")
    var updatedAt: Date? = null,

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    val registrations: List<CourseRegistration>? = null
)