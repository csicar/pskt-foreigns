package Foreign.Effect.Aff;

import kotlinx.coroutines.*

val __pure = { a: Any ->
    GlobalScope.async {
        a
    }
}

val __throwError = {
    TODO()
}

val __catchError = {
    TODO()
}

val __fork = { bool: Any ->
    { aff: Any ->
        TODO()
    }
}

val __map = { f: Any ->
    { aff: Any ->
        f as (Any) -> Any; aff as Deferred<Any>
        GlobalScope.async {
            f(aff.await())
        }
    }
}

val __bind = { aff: Any ->
    { f: Any ->
        aff as Deferred<Any>; f as (Any) -> Deferred<Any>
        GlobalScope.async {
            f(aff.await()).await()
        }
    }
}

val __delay = { right: Any, delay: Any ->
    TODO()
}

val __liftEffect = { eff: Any ->
    eff as () -> Any
    GlobalScope.async {
        eff()
    }
}

val __parAffMap = {
    TODO()
}
val __parAffAlt = {
    TODO()
}

val __parAffApply = {
    TODO()
}

val __makeFiber = { ffiUtil: Any, aff: Any ->

    {
        aff as Deferred<Any>
        val runVal = {
            GlobalScope.async { aff.await() }
            Unit
        }
        //return a fiber
        mapOf<String, Any>(
                "kill" to { TODO() },
                "join" to { TODO() },
                "onComplete" to { TODO() },
                "isSuspended" to { TODO() },
                "run" to runVal
        )
    }
}

val __makeSupervisedFiber = {
    TODO()
}

val __killAll = {
    TODO()
}

val __sequential = {
    TODO()
}

val generalBracket = {
    TODO()
}

val makeAff = {
    TODO()
}

