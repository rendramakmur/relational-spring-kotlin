package relationalapikotlin.relationalapikotlin.entity

import javax.persistence.*

@Entity
@Table(name = "students")
data class Student (
    var name: String = "",

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(
        name = "student_subject",
        joinColumns = arrayOf(JoinColumn(name="student_id", referencedColumnName = "id")),
        inverseJoinColumns = arrayOf(JoinColumn(name="subject_id", referencedColumnName = "id"))
    )
    var subjects: List<Any?> = mutableListOf(),

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    var id: Long = -1
)