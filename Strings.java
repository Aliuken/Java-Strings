package myjava.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

public final class Strings {
    public static final String EMPTY_STRING = "";

    public static final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
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
    };

    public static final Comparator<String> STRING_COMPARATOR_IGNORE_CASE = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
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
    };

    private Strings() {
        throw new AssertionError("No java.util.Strings instances for you!");
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }

    public static String strip(String str) {
        return (str != null) ? str.strip() : null;
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
        if (str == null)
            throw new NullPointerException();
        if (str.isEmpty())
            throw new IllegalArgumentException();
        return str;
    }

    public static String requireNonNullNorWhitespace(String str) {
        if (str == null)
            throw new NullPointerException();

        str = str.strip();

        if (str.isEmpty())
            throw new IllegalArgumentException();
        return str;
    }

    public static String requireNonNullNorEmpty(String str, String message) {
        if (str == null)
            throw new NullPointerException(message);
        if (str.isEmpty())
            throw new IllegalArgumentException(message);
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, String message) {
        if (str == null)
            throw new NullPointerException(message);

        str = str.strip();

        if (str.isEmpty())
            throw new IllegalArgumentException(message);
        return str;
    }

    public static String requireNonNullNorEmpty(String str, Supplier<String> messageSupplier) {
        if (str == null)
            throw new NullPointerException(messageSupplier == null ?
                    null : messageSupplier.get());
        if (str.isEmpty())
            throw new IllegalArgumentException(messageSupplier == null ?
                    null : messageSupplier.get());
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, Supplier<String> messageSupplier) {
        if (str == null)
            throw new NullPointerException(messageSupplier == null ?
                    null : messageSupplier.get());

        str = str.strip();

        if (str.isEmpty())
            throw new IllegalArgumentException(messageSupplier == null ?
                    null : messageSupplier.get());
        return str;
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) {
        return (str != null && !str.isEmpty()) ? str : requireNonNullNorEmpty(defaultStr, "defaultStr");
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str : requireNonNullNorWhitespace(defaultStr, "defaultStr");
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) {
        return (str != null && !str.isEmpty()) ? str
                : requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str
                : requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }
}
