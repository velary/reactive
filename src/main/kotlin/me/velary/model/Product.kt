package me.velary.model

import me.velary.config.ApplicationConfiguration
import org.springframework.data.annotation.Id
import java.beans.ConstructorProperties

data class Product
@ConstructorProperties("id", "name", "currency", "price")
constructor(
    @Id val id: Long,
    val name: String,
    val currency: Currency,
    val price: Double,
) {
    fun convertCurrency(neededCurrency: Currency): Product =
        if (currency == neededCurrency) this
        else copy(price = price * ApplicationConfiguration.conversions[currency]!![neededCurrency]!!)
}