@file:Suppress("UNCHECKED_CAST")
package Foreign.Effect.Unsafe;

val unsafePerformEffect = { f: Any -> 
  f as () -> Any
  f()
}