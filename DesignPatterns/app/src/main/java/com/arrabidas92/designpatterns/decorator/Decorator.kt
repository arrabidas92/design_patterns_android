package com.arrabidas92.designpatterns.decorator

/**
 * The decorator pattern attaches additional responsabilities to an object dynamically.
 * We don't need to modify the behavior at compile time instead it changes at runtime.
 * Decorators provides flexible alternative to subclassing for extending functionnality.
 */

interface Beverage {
    fun getCost(): Int
    fun getDescription(): String
}

interface BeverageDecorator: Beverage {
    val beverage: Beverage
}

class CaramelDecorator(
    override val beverage: Beverage
): BeverageDecorator {
    override fun getCost(): Int {
        return beverage.getCost() + 2
    }

    override fun getDescription(): String {
        return beverage.getDescription() + "\nDecorated with Caramel"
    }
}

class ChocolateDecorator(
    override val beverage: Beverage
): BeverageDecorator {
    override fun getCost(): Int {
        return beverage.getCost() + 3
    }

    override fun getDescription(): String {
        return beverage.getDescription() + "\nDecorated with Chocolate"
    }
}

class Espresso: Beverage {
    override fun getCost(): Int {
        return 1
    }

    override fun getDescription(): String {
        return "It's an Espresso"
    }
}
