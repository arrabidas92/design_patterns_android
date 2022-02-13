package com.arrabidas92.designpatterns.abstractfactory

/**
 * The abstract factory method provides an interface for creating families of related or dependent objects.
 * Without specifying their concrete classes.
 */

interface AbstractFactory {
    fun createProductA(): AbstractProductA
    fun createProductB(): AbstractProductB
}

interface AbstractProductA {
    fun usefulFunctionA(): String
}

interface AbstractProductB {
    fun usefulFunctionB(): String
    fun anotherUsefulFunctionB(collaborator: AbstractProductA): String
}

class ConcreteProductA1: AbstractProductA {

    override fun usefulFunctionA(): String {
        return "The result of the product A1."
    }
}

class ConcreteProductA2: AbstractProductA {

    override fun usefulFunctionA(): String {
        return "The result of the product A2."
    }
}

class ConcreteProductB1: AbstractProductB {

    override fun usefulFunctionB(): String {
        return "The result of the product B1."
    }

    override fun anotherUsefulFunctionB(collaborator: AbstractProductA): String {
        val result = collaborator.usefulFunctionA()
        return "The result of the B1 collaborating with the $result"
    }
}

class ConcreteProductB2: AbstractProductB {

    override fun usefulFunctionB(): String {
        return "The result of the product B2."
    }

    override fun anotherUsefulFunctionB(collaborator: AbstractProductA): String {
        val result = collaborator.usefulFunctionA()
        return "The result of the B2 collaborating with the $result"
    }
}

class ConcreteFactory1: AbstractFactory {

    override fun createProductA(): AbstractProductA {
        return ConcreteProductA1()
    }

    override fun createProductB(): AbstractProductB {
        return ConcreteProductB1()
    }
}

class ConcreteFactory2: AbstractFactory {

    override fun createProductA(): AbstractProductA {
        return ConcreteProductA2()
    }

    override fun createProductB(): AbstractProductB {
        return ConcreteProductB2()
    }
}

class AbstractFactoryClient {

    companion object {
        fun someClientCode(factory: AbstractFactory) {
            val productA = factory.createProductA()
            val productB = factory.createProductB()

            println(productB.usefulFunctionB())
            println(productB.anotherUsefulFunctionB(productA))
        }
    }
}