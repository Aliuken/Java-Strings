package java.util;

import java.util.function.Supplier;

public final class Strings {
    public static final String EMPTY_STRING = "";

    private Strings() {
        throw new AssertionError("No java.util.Strings instances for you!");
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }

    public static String requireNonNullNorEmpty(String str) {
        if (str == null)
            throw new NullPointerException();
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

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    public static boolean nonNullNorEmpty(String str) {
        return (str != null && !str.isEmpty());
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) {
        return (str != null && !str.isEmpty()) ? str : requireNonNullNorEmpty(defaultStr, "defaultStr");
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) {
        return (str != null && !str.isEmpty()) ? str
                : requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
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
}
