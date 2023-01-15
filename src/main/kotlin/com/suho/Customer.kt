package com.suho

import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    @SequenceGenerator(
        name = "customer_id_sequence",
        sequenceName = "customer_id_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
    )
    var id: Int? = null,
    var name: String? = "",
    var email: String? = "",
    var age: Int? = null,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id!!
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + age!!
        return result
    }

    /*override fun toString(): String {
        return "Customer(id=$id, name='$name', email='$email', age=$age)"
    }*/



}