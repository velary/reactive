package me.velary.service

import me.velary.model.Product
import me.velary.model.User
import me.velary.repos.ProductRepository
import me.velary.repos.UserRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class UserService(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
) {
    fun add(user: User): Mono<User> = userRepository.insert(user)

    operator fun get(id: Long): Mono<User?> = userRepository.findById(id)

    fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    fun getProducts(id: Long): Flux<Product> =
        userRepository.findById(id)
            .flatMapMany { user -> productRepository.findAll().map { it!!.convertCurrency(user!!.currency) } }
}