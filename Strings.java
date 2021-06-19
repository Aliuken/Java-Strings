package myjava.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

public final class Strings {
    public static final String EMPTY_STRING = "";
    public static final Comparator<String> STRING_COMPARATOR = ((String a, String b) -> Strings.compare(a, b));
    public static final Comparator<String> STRING_COMPARATOR_IGNORE_CASE = ((String a, String b) -> Strings.compareIgnoreCase(a, b));

    private Strings() {
        throw new AssertionError("No myjava.util.Strings instances for you!");
    }

    public static boolean equals(String a, String b) {
        return (a == b) || (a != null && a.equals(b));
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

    public static boolean isNull(String str) {
        return (str == null);
    }

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    public static boolean isNullOrWhitespace(String str) {
        return (str == null || str.strip().isEmpty());
    }

    public static boolean nonNull(String str) {
        return (str != null);
    }

    public static boolean nonNullNorEmpty(String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean nonNullNorWhitespace(String str) {
        return (str != null && !str.strip().isEmpty());
    }

    public static String requireNonNull(String str) throws Throwable {
        str = StringExceptionsRecord.requireNonNull(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNullNorEmpty(String str) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorEmpty(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNullNorWhitespace(String str) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorWhitespace(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNull(String str, String nullStringMessage) throws Throwable {
        str = StringExceptionsRecord.requireNonNull(str, StringExceptionsRecord.createFromMessages(nullStringMessage, null, null));
        return str;
    }

    public static String requireNonNullNorEmpty(String str, String nullStringMessage, String emptyStringMessage) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorEmpty(str, StringExceptionsRecord.createFromMessages(nullStringMessage, emptyStringMessage, null));
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, String nullStringMessage, String emptyStringMessage, String whitespaceStringMessage) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorWhitespace(str, StringExceptionsRecord.createFromMessages(nullStringMessage, emptyStringMessage, whitespaceStringMessage));
        return str;
    }

    public static String requireNonNull(String str, Supplier<String> nullStringMessageSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNull(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, null, null));
        return str;
    }

    public static String requireNonNullNorEmpty(String str, Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorEmpty(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, emptyStringMessageSupplier, null));
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, Supplier<String> whitespaceStringMessageSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorWhitespace(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier));
        return str;
    }

    public static String requireNonNullElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNull(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, null, null));
        return str;
    }

    public static String requireNonNullNorEmptyElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorEmpty(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, emptyStringThrowableSupplier, null));
        return str;
    }

    public static String requireNonNullNorWhitespaceElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) throws Throwable {
        str = StringExceptionsRecord.requireNonNullNorWhitespace(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier));
        return str;
    }

    public static String requireNonNullElse(String str, String defaultStr) throws Throwable {
        return (str != null) ? str :
                requireNonNull(defaultStr, "defaultStr");
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) throws Throwable {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(defaultStr, "defaultStr", "defaultStr");
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) throws Throwable {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(defaultStr, "defaultStr", "defaultStr", "defaultStr");
    }

    public static String requireNonNullElseGet(String str, Supplier<String> supplier) throws Throwable {
        return (str != null) ? str :
                requireNonNull(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) throws Throwable {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()");
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) throws Throwable {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()", "supplier.get()");
    }
}