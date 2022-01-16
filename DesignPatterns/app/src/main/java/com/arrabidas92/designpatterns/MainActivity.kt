package com.arrabidas92.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        // - Strategy pattern
    }
}