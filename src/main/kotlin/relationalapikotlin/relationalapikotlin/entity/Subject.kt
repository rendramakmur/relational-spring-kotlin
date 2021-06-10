package relationalapikotlin.relationalapikotlin.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity @Table(name="subjects")
data class Subject (
        @Id
        var id: Long = -1,
        var name: String = "",
        @ManyToMany(mappedBy = "subjects")
        var students: List<Any?> = mutableListOf()
)