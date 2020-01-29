@file:Suppress("UNCHECKED_CAST")
package Foreign.Debug.Trace


val trace = { _: Any ->
    {x : Any ->
        {k : Any ->
            k as (Any) -> Any
            println(x)
            k(Unit);
        };
    };
};

val spy = { _: Any ->
    { tag: Any ->
        { x: Any ->
            tag as String
            println("$tag : $x")
            x;
        };
    };
};