package myjava.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

public final class Strings {
    public static final String EMPTY_STRING = "";
    public static final Comparator<String> STRING_COMPARATOR = ((String a, String b) -> Strings.compare(a, b));
    public static final Comparator<String> STRING_COMPARATOR_IGNORE_CASE = ((String a, String b) -> Strings.compareIgnoreCase(a, b));

    private Strings() {
        throw new AssertionError("No java.util.Strings instances for you!");
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }

    public static String strip(String str) {
        return (str != null) ? str.strip() : null;
    }

    public static int compare(String a, String b) {
        if(a == b) {
            return 0;
        }

        if(a == null) {
            return -1;
        }

        if(b == null) {
            return 1;
        }

        return a.compareTo(b);
    }

    public static int compareIgnoreCase(String a, String b) {
        if(a == b) {
            return 0;
        }

        if(a == null) {
            return -1;
        }

        if(b == null) {
            return 1;
        }

        return a.compareToIgnoreCase(b);
    }

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    public static boolean isNullOrWhitespace(String str) {
        return (str == null || str.strip().isEmpty());
    }

    public static boolean nonNullNorEmpty(String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean nonNullNorWhitespace(String str) {
        return (str != null && !str.strip().isEmpty());
    }

    public static String requireNonNullNorEmpty(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static String requireNonNullNorEmpty(String str, String nullMessage, String emptyMessage) {
        if (str == null) {
            throw new NullPointerException(nullMessage);
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(emptyMessage);
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, String nullMessage, String whitespaceMessage) {
        if (str == null) {
            throw new NullPointerException(nullMessage);
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw new IllegalArgumentException(whitespaceMessage);
        }
        return str;
    }

    public static String requireNonNullNorEmpty(String str, Supplier<String> nullMessageSupplier, Supplier<String> emptyMessageSupplier) {
        if (str == null) {
            throw new NullPointerException(nullMessageSupplier != null ? nullMessageSupplier.get() : null);
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(emptyMessageSupplier != null ? emptyMessageSupplier.get() : null);
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, Supplier<String> nullMessageSupplier, Supplier<String> whitespaceMessageSupplier) {
        if (str == null) {
            throw new NullPointerException(nullMessageSupplier != null ? nullMessageSupplier.get() : null);
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw new IllegalArgumentException(whitespaceMessageSupplier != null ? whitespaceMessageSupplier.get() : null);
        }
        return str;
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(defaultStr, "defaultStr", "defaultStr");
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(defaultStr, "defaultStr", "defaultStr");
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()");
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()");
    }

    public static <X extends Throwable> String requireNonNullNorEmptyElseThrow(String str, Supplier<? extends X> nullExceptionSupplier, Supplier<? extends X> emptyExceptionSupplier) throws X {
        if (str == null) {
            throw nullExceptionSupplier.get();
        }
        if (str.isEmpty()) {
            throw emptyExceptionSupplier.get();
        }
        return str;
    }

    public static <X extends Throwable> String requireNonNullNorWhitespaceElseThrow(String str, Supplier<? extends X> nullExceptionSupplier, Supplier<? extends X> whitespaceExceptionSupplier) throws X {
        if (str == null) {
            throw nullExceptionSupplier.get();
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw whitespaceExceptionSupplier.get();
        }
        return str;
    }
}
