@file:Suppress("UNCHECKED_CAST")
package Foreign.Data.String.Unsafe;

val charAt = { i: Any ->
  {s: Any ->
    i as Int; s as String
    if (i >= 0 && i < s.length) {
      s.toCharArray()[i]
    } else {
      error("Data.String.Unsafe.charAt: Invalid index.");
    }
  };
};

val char = { s: Any ->
  s as String
  if (s.length == 1) {
    s.toCharArray()[0]
  } else {
    error("Data.String.Unsafe.char: Expected string of length 1.");
  }
};