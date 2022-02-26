package com.arrabidas92.designpatterns.command

/**
 *  The command pattern is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action
 *  or trigger an event at a later time.
 */

/// The Command interface declares a method for executing a command.
interface Command {
    fun execute()
}

/// Some commands can implement simple operations on their own.
class SimpleCommand(
    private var payload: String
): Command {
    override fun execute() {
        print("SimpleCommand: See, I can do simple things like printing ($payload)")
    }
}

/// However, some commands can delegate more complex operations to other
/// objects, called "receivers."
class ComplexCommand(
    private var receiver: Receiver,
    private var a: String,
    private var b: String
): Command {
    /// Commands can delegate to any methods of a receiver.
    override fun execute() {
        print("ComplexCommand: Complex stuff should be done by a receiver object.\n")
        receiver.doSomething(a)
        receiver.doSomethingElse(b)
    }
}

/// The Receiver classes contain some important business logic. They know how to
/// perform all kinds of operations, associated with carrying out a request. In
/// fact, any class may serve as a Receiver.
class Receiver {

    fun doSomething(a: String) {
        print("Receiver: Working on ($a)\n")
    }

    fun doSomethingElse(b: String) {
        print("Receiver: Also working on ($b)\n")
    }
}

/// The Invoker is associated with one or several commands. It sends a request
/// to the command.
class Invoker(
    private var onStart: Command?,
    private var onFinish: Command?
) {
    /// The Invoker does not depend on concrete command or receiver classes. The
    /// Invoker passes a request to a receiver indirectly, by executing a
    /// command.
    fun doSomethingImportant() {

        print("Invoker: Does anybody want something done before I begin?")

        onStart?.execute()

        print("Invoker: ...doing something really important...")
        print("Invoker: Does anybody want something done after I finish?")

        onFinish?.execute()
    }
}

class CommandClient {
    companion object {
        fun testCommand() {
            /// The client code can parameterize an invoker with any commands.
            val receiver = Receiver()
            val invoker = Invoker(
                SimpleCommand("Say Hi!"),
                ComplexCommand(receiver, "Send email", "Save report")
            )

            invoker.doSomethingImportant()
        }
    }
}