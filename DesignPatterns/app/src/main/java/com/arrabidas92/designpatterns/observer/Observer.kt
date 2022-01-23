package com.arrabidas92.designpatterns.observer

/**
 * The observer pattern is used to allow an object to publish changes to its state. Other objects subscribe to be immediately notified of any changes.
 * It's a push strategy versus a poll strategy meaning that new states are pushed instead of asked again and again.
 */

interface IObservable {
    fun add(observer: IObserver)
    fun remove(observer: IObserver)
    fun getState(): Int
    fun setState(number: Int)
}

interface IObserver {
    fun update()
}

class ConcreteObservable: IObservable {
    private var _observers = mutableListOf<IObserver>()
    private var _state: Int = 0

    override fun add(observer: IObserver) {
        _observers.add(observer)
    }

    override fun remove(observer: IObserver) {
        _observers.remove(observer)
    }

    override fun getState(): Int {
        return _state
    }

    override fun setState(number: Int) {
        _state = number
        notifyState()
    }

    private fun notifyState() {
        _observers.forEach {
            it.update()
        }
    }
}

class ConcreteObserver(
    private val _id: String,
    private val _observable: IObservable
): IObserver {
    override fun update() {
        println("Observer $_id received state ${_observable.getState()}")
    }
}