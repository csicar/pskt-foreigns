@file:Suppress("UNCHECKED_CAST")
package Foreign.Data.String.CodePoints;

val __unsafeCodePointAt0 = { fallback: Any ->
  { str: Any ->
    str as String
    str.codePointAt(0)
  }
};

val __codePointAt = { fallback: Any ->
  { just: Any ->
    { nothing: Any ->
      { unsafeCodePointAt0: Any ->
        { index: Any ->
          { str: Any ->
            str as String; just as (Any) -> Any; index as Int
            val length = str.length;
            if (index < 0 || index >= length) {
              nothing
            } else {
              just(str.codePointAt(index))
            }

          }
        };
      };
    };
  };
};

val __countPrefix = { fallback: Any ->
  { unsafeCodePointAt0: Any ->
    fallback
  };
};

val __fromCodePointArray = { singleton: Any ->
  { cps: Any ->
    cps as Array<Int>; singleton as (Any) -> Int
    String(cps.map { singleton(it) }.toIntArray(), 0, cps.size)
  }
};

val __singleton = { fallback: Any ->
  { cp: Any ->
    cp as Int
    String(intArrayOf(cp), 0, 1)
  }
};

val __take = { fallback: Any ->
  { n: Any ->
    { str: Any ->
      str as String; n as Int
      str.codePointAt(n)
    }
  };
};

val __toCodePointArray = { fallback: Any ->
  { unsafeCodePointAt0: Any ->
    { str: Any ->
      str as String
      val list = mutableListOf<Int>()
      var offset = 0;
      while (offset < str.length) {
        val codePoint = str.codePointAt(offset)
        offset += Character.charCount(codePoint)
      }
      list.toList()
    }
  };
};