package com.test.bitpandachallenge.model



sealed class Currency {
    abstract val name: String
    abstract val symbol: String
    abstract val id: String
    abstract val logo: String
    abstract val precision: Int
}

data class Fiat(
    override val name: String,
    override val symbol: String,
    override val id: String,
    override val logo: String,
    override val precision: Int = 2,
) : Currency()

data class Metal(
    override val name: String,
    override val symbol: String,
    override val id: String,
    override val logo: String,
    override val precision: Int = 3,
    val price: Double
) : Currency()

data class Cryptocoin(
    override val name: String,
    override val symbol: String,
    override val id: String,
    override val logo: String,
    override val precision: Int = 4,
    val price: Double
) : Currency()