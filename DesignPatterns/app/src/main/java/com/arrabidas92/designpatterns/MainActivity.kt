package com.arrabidas92.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}