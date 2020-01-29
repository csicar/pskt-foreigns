@file:Suppress("UNCHECKED_CAST")
package Foreign.Data.String.Regex;

import java.util.regex.PatternSyntaxException

class PsRegex(val patternStr: String, val optionsStr: String) {
    inner class UnrecognizedOptionException(val opt: Char) : Exception("Option does not exists: $opt")

    enum class Option(val repr: Char, val patternOption: RegexOption?) {
        MULTILINE('m', RegexOption.MULTILINE),
        IGNORE_CASE('i', RegexOption.IGNORE_CASE),
        GLOBAL('g', null),
        STICKY('y', null),
        UNICODE('u', null),
    }

    val options = optionsStr.toCharArray().map { op ->
        Option.values().find { it.repr == op } ?: throw UnrecognizedOptionException(op)
    }.toSet()
    val regex = Regex(patternStr, options.mapNotNull { it.patternOption }.toSet())
}

val showRegex_tick = { r: Any ->
    r as PsRegex
    r.regex.toString();
};

val regex_tick = { left: Any ->
    { right: Any ->
        { s1: Any ->
            { s2: Any ->
                left as (Any) -> Any; right as (Any) -> Any; s1 as String; s2 as String
                try {
                    right(PsRegex(s1, s2))
                } catch (e: PatternSyntaxException) {
                    left(e.toString());
                } catch (e: PsRegex.UnrecognizedOptionException) {
                    left(e.toString())
                }
            };
        };
    };
};

val source = { r: Any ->
    r as PsRegex
    r.regex.pattern;
};

val flags_tick = { r: Any ->
    r as PsRegex
    mapOf<String, Boolean>(
            "multiline" to r.options.contains(PsRegex.Option.MULTILINE),
            "ignoreCase" to r.options.contains(PsRegex.Option.IGNORE_CASE),
            "global" to r.options.contains(PsRegex.Option.GLOBAL),
            "sticky" to r.options.contains(PsRegex.Option.STICKY),
            "unicode" to r.options.contains(PsRegex.Option.UNICODE)
    )
};

val test = { r: Any ->
    { s: Any ->
        r as PsRegex; s as String
        r.regex.matches(s)
    };
};

val __match = { just: Any ->
    { nothing: Any ->
        { r: Any ->
            { s: Any ->
                just as (Any) -> Any; r as PsRegex; s as String
                if (r.options.contains(PsRegex.Option.GLOBAL)) {
                    //TODO instead of map(just(it)) distinguish for empty capturing group
                    // https://github.com/purescript/purescript-strings/blob/v4.0.1/src/Data/String/Regex.purs#L91
                    val ms = r.regex.findAll(s).map { just(it.value) }
                    just(ms.toList())
                } else {
                    val m = r.regex.find(s)
                    if (m == null) {
                        nothing
                    } else {
                        just(m.value)
                    }
                }
            };
        };
    };
};

val replace = { r: Any ->
    { s1: Any ->
        { s2: Any ->
            r as PsRegex; s1 as String; s2 as String
            r.regex.replace(s2, s1)
        };
    };
};

val replace_tick = { r: Any ->
    { f: Any ->
        { s2: Any ->
            r as PsRegex; f as (String) -> ((List<String>) -> String); s2 as String
            r.regex.replace(s2) { match ->
                f(match.value)(match.groupValues) //TODO Check if correct
            }
        };
    };
};

val __search = { just: Any ->
    { nothing: Any ->
        { r: Any ->
            { s: Any ->
                just as (Any) -> Any; r as PsRegex; s as String
                val result = r.regex.find(s);
                if (result == null) {
                    nothing
                } else {
                    just(result.range.first)
                }
            };
        };
    };
};

val split = { r: Any ->
    { s: Any ->
      r as PsRegex; s as String
      r.regex.split(s)
    };
};