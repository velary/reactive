package me.velary.service

import me.velary.model.Product
import me.velary.repos.ProductRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ProductService(private val productRepository: ProductRepository) {

    fun add(product: Product): Mono<Product> = productRepository.insert(product)

    operator fun get(id: Long): Mono<Product?> = productRepository.findById(id)

    fun delete(id: Long) {
        productRepository.deleteById(id)
    }
}