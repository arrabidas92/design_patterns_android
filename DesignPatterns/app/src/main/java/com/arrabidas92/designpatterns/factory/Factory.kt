package com.arrabidas92.designpatterns.factory

/**
 * The factory method pattern defines an interface for creating an object.
 * But let subclasses decide which class to instantiate.
 * Factory method let subclasses defer instanciation to subclasses.
 */

interface ResourceServer {
    val pathURL: String
}

class ProductionResourceServer: ResourceServer {
    override val pathURL: String
        get() = "https://prod.api"
}

class DevelopmentResourceServer: ResourceServer {
    override val pathURL: String
        get() = "https://dev.api"
}

interface Factory {
    fun createResourceServer(): ResourceServer
}

class ResourceServerFactory(
    private val environment: Environment
): Factory {
    enum class Environment {
        prod, dev
    }

    override fun createResourceServer(): ResourceServer {
        return when (environment) {
            Environment.prod -> ProductionResourceServer()
            Environment.dev -> DevelopmentResourceServer()
        }
    }
}