package Foreign.Record.Builder;


val copyRecord = {rec: Any ->
  rec as Map<String, Any>
  HashMap(rec)
}

val unsafeInsert = {l: Any ->
  { a: Any ->
    { rec: Any ->
      l as String; rec as Map<String, Any>
      rec + mapOf(l to a)
    };
  };
};

val unsafeModify = {l: Any ->
  { f: Any ->
    { rec: Any ->
      l as String; rec as Map<String, Any>; f as (Any) -> Any
      rec + mapOf(l to f(rec[l]!!))
    };
  };
};

val unsafeDelete = {l: Any ->
  { rec: Any ->
    l as String; rec as Map<String, Any>
    rec.filterKeys { it != l }
  };
};

val unsafeRename = {l1: Any ->
  { l2: Any ->
    { rec: Any ->
      l1 as String; l2 as String; rec as Map<String, Any>
      val mutable = rec.toMutableMap()
      mutable.put(l2, mutable.remove(l1)!!)
      mutable.toMap()
    };
  };
};