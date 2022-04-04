package me.velary.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.Key
import com.natpryce.konfig.stringType
import me.velary.model.Currency.*
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@EnableReactiveMongoRepositories
object ApplicationConfiguration : AbstractReactiveMongoConfiguration() {

    private val configuration = ConfigurationProperties.fromResource("defaults.properties")

    val conversions = mapOf(
        USD to mapOf(
            RUB to 83.4285,
            EUR to 0.9054,
        ),
        EUR to mapOf(
            RUB to 92.1468,
            USD to 1.1045,
        ),
        RUB to mapOf(
            USD to 0.0109,
            EUR to 0.012,
        ),
    )

    @Bean fun mongoClient(): MongoClient = MongoClients.create(configuration[Key("mongo.url", stringType)])

    override fun getDatabaseName() = configuration[Key("mongo.database.name", stringType)]

    override fun reactiveMongoClient() = mongoClient()
}