package com.arrabidas92.designpatterns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arrabidas92.designpatterns.abstractfactory.AbstractFactoryClient
import com.arrabidas92.designpatterns.abstractfactory.ConcreteFactory1
import com.arrabidas92.designpatterns.abstractfactory.ConcreteFactory2
import com.arrabidas92.designpatterns.command.CommandClient
import com.arrabidas92.designpatterns.decorator.CaramelDecorator
import com.arrabidas92.designpatterns.decorator.ChocolateDecorator
import com.arrabidas92.designpatterns.decorator.Espresso
import com.arrabidas92.designpatterns.factory.ResourceServerFactory
import com.arrabidas92.designpatterns.observer.ConcreteObservable
import com.arrabidas92.designpatterns.observer.ConcreteObserver
import com.arrabidas92.designpatterns.strategy.ClientStrategy
import com.arrabidas92.designpatterns.strategy.DieselStrategy
import com.arrabidas92.designpatterns.strategy.ElectricStrategy
import com.arrabidas92.designpatterns.strategy.GasolineStrategy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // - Strategy pattern

        val clientA = ClientStrategy(DieselStrategy())
        clientA.fillUp()

        val clientB = ClientStrategy(ElectricStrategy())
        clientB.fillUp()

        val clientC = ClientStrategy(GasolineStrategy())
        clientC.fillUp()

        // - Observer pattern

        val observable = ConcreteObservable()
        val firstObserver = ConcreteObserver("1", observable)
        val secondObserver = ConcreteObserver("2", observable)

        observable.add(firstObserver)
        observable.add(secondObserver)

        observable.setState(1)
        observable.setState(2)

        observable.remove(firstObserver)

        observable.setState(3)

        observable.remove(secondObserver)

        observable.setState(4)

        // - Decorator pattern

        val espresso = Espresso()
        println(espresso.getDescription())
        println(espresso.getCost())

        val espressoWithCaramel = CaramelDecorator(espresso)
        println(espressoWithCaramel.getDescription())
        println(espressoWithCaramel.getCost())

        val espressoWithChocolate = ChocolateDecorator(espresso)
        println(espressoWithChocolate.getDescription())
        println(espressoWithChocolate.getCost())

        val espressoWithChocolateCaramel = ChocolateDecorator(espressoWithCaramel)
        println(espressoWithChocolateCaramel.getDescription())
        println(espressoWithChocolateCaramel.getCost())

        val espressoWithCaramelChocolate = CaramelDecorator(espressoWithChocolate)
        println(espressoWithCaramelChocolate.getDescription())
        println(espressoWithCaramelChocolate.getCost())

        // - Factory pattern

        val factory = ResourceServerFactory(ResourceServerFactory.Environment.dev)
        val resourceServerCreated = factory.createResourceServer()
        println(resourceServerCreated.pathURL)

        // - Abstract Factory pattern

        println("Client: Testing client code with the first factory type:")
        AbstractFactoryClient.someClientCode(ConcreteFactory1())

        println("Client: Testing the same client code with the second factory type:")
        AbstractFactoryClient.someClientCode(ConcreteFactory2())

        // - Command pattern

        CommandClient.testCommand()
    }
}