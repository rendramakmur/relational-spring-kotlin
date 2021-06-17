package relationalapikotlin.relationalapikotlin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name =  "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "created_at")
    @CreationTimestamp
    var createdAt: Date? = null,

    @Column(name = "updated_at")
    var updatedAt: Date? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    val registrations: List<CourseRegistration>? = null
)