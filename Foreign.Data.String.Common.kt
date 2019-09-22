package Foreign.Data.String.Common;

val __localeCompare = { lt: Any ->
    { eq: Any ->
        { gt: Any ->
            { s1: Any ->
                { s2: Any ->
                    s1 as String; s2 as String
                    var result = s1.compareTo(s2);
                    when {
                        result < 0 -> lt
                        result > 0 -> gt
                        else -> eq
                    }
                };
            };
        };
    };
};

val replace = { s1: Any ->
    { s2: Any ->
        { s3: Any ->
            s1 as String; s2 as String; s3 as String;

            s3.replaceFirst(s1, s2);
        };
    };
};

val replaceAll = { s1: Any ->
    { s2: Any ->
        { s3: Any ->
            s1 as String; s2 as String; s3 as String;
            s3.replace(s1, s2)
        };
    };
};

val split = { sep: Any ->
    { s: Any ->
        sep as String; s as String;
        s.split(sep);
    };
};

val toLower = { s: Any ->
    s as String;
    s.toLowerCase();
};

val toUpper = { s: Any ->
    s as String;

    s.toUpperCase();
};

val trim = { s: Any ->
    s as String;

    s.trim();
};

val joinWith = { s: Any ->
    { xs: Any ->
        s as String; xs as List<String>
        xs.joinToString(s)
    };
};