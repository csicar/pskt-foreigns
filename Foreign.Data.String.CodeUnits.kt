@file:Suppress("UNCHECKED_CAST")
package Foreign.Data.String.CodeUnits;

val fromCharArray = { a: Any ->
    a as List<Char>
    a.joinToString("")
};

val toCharArray = { s: Any ->
    s as String
    s.toCharArray().toList()
};

val singleton = { c: Any ->
    c as Char
    c.toString()
};

val __charAt = { just: Any ->
    { nothing: Any ->
        { i: Any ->
            { s: Any ->
                just as (Any) -> Any; i as Int; s as String
                if (i >= 0 && i < s.length) {
                    just(s.toCharArray()[i])
                } else {
                    nothing
                }
            };
        };
    };
};

val __toChar = { just: Any ->
    { nothing: Any ->
        { s: Any ->
            s as String; just as (Any) -> Any
            if (s.length == 1) {
                just(s.toCharArray()[0])
            } else {
                nothing
            }
        };
    };
};

val length = { s: Any ->
    s as String
    s.length;
};

val countPrefix = { p: Any ->
    { s: Any ->
        s as String; p as (Char) -> Boolean
        var i = 0;
        val chrs = s.toCharArray()
        while (i < s.length && p(chrs[i])) i++;
        i;
    };
};

val __indexOf = { just: Any ->
    { nothing: Any ->
        { x: Any ->
            { s: Any ->
                s as String; just as (Any) -> Any; x as String
                val i = s.indexOf(x);
                if (i == -1) {
                    nothing
                } else {
                    just(i)
                }
            };
        };
    };
};

val __indexOf_tick = { just: Any ->
    { nothing: Any ->
        { x: Any ->
            { startAt: Any ->
                { s: Any ->
                    just as (Any) -> Any; x as String; s as String; startAt as Int
                    if (startAt < 0 || startAt > s.length) {
                        nothing
                    } else {
                        val i = s.indexOf(x, startAt);
                        if (i == -1) {
                            nothing
                        } else {
                            just(i)
                        }
                    }
                };
            };
        };
    };
};

val __lastIndexOf = { just: Any ->
  { nothing: Any ->
    { x: Any ->
      { s: Any ->
        s as String; just as (Any) -> Any; x as String
        val i = s.lastIndexOf(x);
        if (i == -1) {
          nothing
        } else {
          just(i)
        }
      };
    };
  };
};

val __lastIndexOf_tick = { just: Any ->
  { nothing: Any ->
    { x: Any ->
      { startAt: Any ->
        { s: Any ->
          just as (Any) -> Any; x as String; s as String; startAt as Int
          if (startAt < 0 || startAt > s.length) {
            nothing
          } else {
            val i = s.lastIndexOf(x, startAt);
            if (i == -1) {
              nothing
            } else {
              just(i)
            }
          }
        };
      };
    };
  };
};

val take = { n: Any ->
    { s: Any ->
      s as String; n as Int
      s.substring(0, n);
    };
};

val drop = { n: Any ->
    { s: Any ->
        s as String; n as Int
        s.substring(n);
    };
};

val __slice = { b: Any ->
    { e: Any ->
        { s: Any ->
          s as String; e as Int; b as Int
            s.substring(b, e);
        };
    };
};

val splitAt = { i: Any ->
    { s: Any ->
      i as Int; s as String
      mapOf<String, Any>(
              "before" to s.substring(0, i),
              "after" to s.substring(i)
      )
    };
};