@file:Suppress("UNCHECKED_CAST")
package Foreign.Partial;

val crashWith = {
  { msg: String ->
    error(msg)
  }
}