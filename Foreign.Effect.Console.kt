@file:Suppress("UNCHECKED_CAST")
package Foreign.Effect.Console

val log = { s: Any ->
  {
    println(s)
  }
};

val warn = { s: Any ->
  {
    println(s)
  }
};

val error = { s: Any ->
  {
    println(s)
  }
};

val info = { s: Any ->
  {
    println(s)
  }
};

val stopWatches = mutableMapOf<String, Long>()

val time = { s: Any ->
  {
    s as String
    stopWatches[s] = System.currentTimeMillis()
  }
};

val timeEnd = { s: Any ->
  {
    val end = System.currentTimeMillis()
    val startTime = stopWatches[s]
    if (startTime == null) {
      println("Timer $s: does not exist")
    } else {
      println("Timer $s : ${end - startTime}ms - Timer was stopped")
    }
  }
};

val timeLog = {s: Any ->
  {
    val now = System.currentTimeMillis()
    val startTime = stopWatches[s]
    if (startTime == null) {
      println("Timer $s does not exist")
    } else {
      println("Timer $s : ${now - startTime}ms")
    }
  }
}

val clear = {
  print("\u001b[H\u001b[2J")
}