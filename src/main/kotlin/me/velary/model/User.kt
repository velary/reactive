package me.velary.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.beans.ConstructorProperties

@Document
data class User
@ConstructorProperties("id", "username", "currency")
constructor(
    @Id val id: Long,
    val username: String,
    val currency: Currency,
)