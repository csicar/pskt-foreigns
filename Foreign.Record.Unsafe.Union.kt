@file:Suppress("UNCHECKED_CAST")
package Foreign.Record.Unsafe.Union;

val unsafeUnionFn = { r1: Any, r2: Any ->
  r1 as Map<String, Any>; r2 as Map<String, Any>
  r1 + r2
};