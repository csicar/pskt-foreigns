package Foreign.Effect.Aff;

import Foreign.PsRuntime.appRun
import kotlinx.coroutines.*

typealias Aff = (CoroutineScope) -> Deferred<Any>

val __pure = { a: Any ->
    { scope: CoroutineScope -> scope.async { a } }
}

val __throwError = { e: Any ->
    /* defer **/{
        println("throwError $e")

    }
}

val __catchError = { ma: Any ->
    { f: Any ->
        TODO()
    }
}

val __fork = { isSuspended: Any ->
    { aff: Any ->
        aff as Aff; isSuspended as Boolean
        { scope: CoroutineScope ->
            scope.async {
                val start = if (isSuspended) { CoroutineStart.LAZY } else { CoroutineStart.DEFAULT }
               val deferredVal = async(start = start) {
                    aff(scope).await()
                }

                mapOf<String, Any>(
                    "kill" to { TODO() },
                    "join" to { TODO() }, //(Either Error a → Effect Unit) → Effect (Effect Unit)
                    "onComplete" to { TODO() },
                    "isSuspended" to { !deferredVal.isActive },
                    "run" to { deferredVal.start() }
                )
            }
        }
    }
}

val __map = { f: Any ->
    { aff: Any ->
        f as (Any) -> Any; aff as Aff
        { scope: CoroutineScope ->
            scope.async {
                f(aff(scope).await())
            }
        }
    }
}

val __bind = { aff: Any ->
    { f: Any ->
        aff as Aff; f as (Any) -> Aff
        { scope: CoroutineScope ->
            scope.async {
                val res = aff(scope).await()
                f(res)(scope).await()
            }
        }
    }
}

val __delay = { right: Any, ms: Any ->
    ms as Double
    { scope: CoroutineScope ->
        scope.async { delay(ms.toLong()) }
    }
}

val __liftEffect = { eff: Any ->
    eff as () -> Any;
    println("liftEffect: $eff");

    { scope: CoroutineScope ->
        scope.async {
            eff()
        }
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
        aff as Aff
        val runVal = {
            runBlocking {
                aff(this).await()
            }
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

val makeAff = { f: Any -> // makeAff :: forall a. ((Either Error a -> Effect Unit) -> Effect Canceler) -> Aff a
    f as (Any) -> Any //:: (Either Error a -> Effect Unit) -> Effect Canceler
    println("makeAff $f");
    { scope: CoroutineScope ->
        scope.async {
            val canceler = f { res: Any -> { println(res); } }.appRun()
            canceler
        }
    }
}

