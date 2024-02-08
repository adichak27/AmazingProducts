package com.cs4520.assignment1


sealed class Product {
    data class Food(
        val name: String,
        val expiryDate: String?,
        val price: Int
    ) : Product()
    data class Equipment(
        val name: String,
        val price: Int
    ) : Product()
}

