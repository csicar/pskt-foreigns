@file:Suppress("UNCHECKED_CAST")
package Foreign.Record.ST;


val freeze = {rec: Any ->
  {
    rec as MutableMap<String, Any>
    rec
  };
};

val thaw = {rec: Any ->
  {
    rec as Map<String, Any>
    rec.toMutableMap()
  };
};

val unsafePeek = {l: Any ->
  { rec: Any -> 
    {
      l as String; rec as MutableMap<String, Any>
      rec[l]!!;
    };
  };
};

val unsafePoke = {l: Any ->
  { a: Any -> 
    { rec: Any -> 
      {
        l as String; rec as MutableMap<String, Any>

        rec[l] = a;
      };
    };
  };
};

val unsafeModify = {l: Any ->
  { f: Any -> 
    { rec: Any -> 
      {
        l as String; rec as MutableMap<String, Any>; f as (Any) -> Any
        rec[l] = f(rec[l]!!);
      };
    };
  };
};