package com.arrabidas92.designpatterns.strategy

/**
 * The strategy pattern is used to create an interchangeable family of algorithms from which the required process is chosen at run-time.
 * It's an entry point to composition versus inheritance.
 * When you feel that the inheritance hierarchy is not only going downards but also horizontally, you may have to choose composition over inheritance.
 * Use dependency injection into the client to reach max flexibility
 */
interface FillableStrategy {
    fun fillUp()
}

class DieselStrategy: FillableStrategy {
    override fun fillUp() {
        println("$this engine must be filled up with diesel")
    }
}

class ElectricStrategy: FillableStrategy {
    override fun fillUp() {
        println("$this engine must be filled up with electricity")
    }
}

class GasolineStrategy: FillableStrategy {
    override fun fillUp() {
        println("$this engine must be filled up with gasoline")
    }
}

class ClientStrategy(
    private val strategy: FillableStrategy
) {
    fun fillUp() {
        strategy.fillUp()
    }
}