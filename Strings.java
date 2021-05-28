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
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static String requireNonNullNorEmpty(String str, StringExceptionMessages stringExceptionMessages) {
        if (str == null) {
            Objects.requireNonNull(stringExceptionMessages, "stringExceptionMessages").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessages, "stringExceptionMessages").throwEmptyStringException();
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionMessages stringExceptionMessages) {
        if (str == null) {
            Objects.requireNonNull(stringExceptionMessages, "stringExceptionMessages").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessages, "stringExceptionMessages").throwEmptyStringException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessages, "stringExceptionMessages").throwWhitespaceStringException();
        }
        return str;
    }

    public static String requireNonNullNorEmpty(String str, StringExceptionMessageSuppliers stringExceptionMessageSuppliers) {
        if (str == null) {
            Objects.requireNonNull(stringExceptionMessageSuppliers, "stringExceptionMessageSuppliers").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessageSuppliers, "stringExceptionMessageSuppliers").throwEmptyStringException();
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionMessageSuppliers stringExceptionMessageSuppliers) {
        if (str == null) {
            Objects.requireNonNull(stringExceptionMessageSuppliers, "stringExceptionMessageSuppliers").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessageSuppliers, "stringExceptionMessageSuppliers").throwEmptyStringException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionMessageSuppliers, "stringExceptionMessageSuppliers").throwWhitespaceStringException();
        }
        return str;
    }

    public static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorEmptyElseThrow(String str, StringExceptionSuppliers<E1, E2, E3> stringExceptionSuppliers) throws E1, E2 {
        if (str == null) {
            Objects.requireNonNull(stringExceptionSuppliers, "stringExceptionSuppliers").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionSuppliers, "stringExceptionSuppliers").throwEmptyStringException();
        }
        return str;
    }

    public static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorWhitespaceElseThrow(String str, StringExceptionSuppliers<E1, E2, E3> stringExceptionSuppliers) throws E1, E2, E3 {
        if (str == null) {
            Objects.requireNonNull(stringExceptionSuppliers, "stringExceptionSuppliers").throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionSuppliers, "stringExceptionSuppliers").throwEmptyStringException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionSuppliers, "stringExceptionSuppliers").throwWhitespaceStringException();
        }
        return str;
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(defaultStr, new StringExceptionMessages("defaultStr", "defaultStr", null));
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(defaultStr, new StringExceptionMessages("defaultStr", "defaultStr", "defaultStr"));
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), new StringExceptionMessages("supplier.get()", "supplier.get()", null));
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), new StringExceptionMessages("supplier.get()", "supplier.get()", "supplier.get()"));
    }
}
