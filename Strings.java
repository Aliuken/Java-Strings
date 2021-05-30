package myjava.util;

import myjava.util.records.StringExceptionsCustom;
import myjava.util.records.StringExceptionsDefault;
import myjava.util.records.StringExceptionsDefaultWithMessage;
import myjava.util.records.StringExceptionsDefaultWithMessageSupplier;

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

    public static String requireNonNullNorEmpty(String str, StringExceptionsDefault stringExceptionsDefault) {
        str = Strings.requireNonNullNorEmptyPrivate(str, stringExceptionsDefault, StringExceptionsDefault.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionsDefault stringExceptionsDefault) {
        str = Strings.requireNonNullNorWhitespacePrivate(str, stringExceptionsDefault, StringExceptionsDefault.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorEmpty(String str, StringExceptionsDefaultWithMessage stringExceptionsDefaultWithMessage) {
        str = Strings.requireNonNullNorEmptyPrivate(str, stringExceptionsDefaultWithMessage, StringExceptionsDefaultWithMessage.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionsDefaultWithMessage stringExceptionsDefaultWithMessage) {
        str = Strings.requireNonNullNorWhitespacePrivate(str, stringExceptionsDefaultWithMessage, StringExceptionsDefaultWithMessage.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorEmpty(String str, StringExceptionsDefaultWithMessageSupplier stringExceptionsDefaultWithMessageSupplier) {
        str = Strings.requireNonNullNorEmptyPrivate(str, stringExceptionsDefaultWithMessageSupplier, StringExceptionsDefaultWithMessageSupplier.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionsDefaultWithMessageSupplier stringExceptionsDefaultWithMessageSupplier) {
        str = Strings.requireNonNullNorWhitespacePrivate(str, stringExceptionsDefaultWithMessageSupplier, StringExceptionsDefaultWithMessageSupplier.INSTANCE_NAME);
        return str;
    }

    public static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorEmptyElseThrow(String str, StringExceptionsCustom<E1, E2, E3> stringExceptionsCustom) throws E1, E2 {
        str = Strings.requireNonNullNorEmptyPrivate(str, stringExceptionsCustom, StringExceptionsCustom.INSTANCE_NAME);
        return str;
    }

    public static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorWhitespaceElseThrow(String str, StringExceptionsCustom<E1, E2, E3> stringExceptionsCustom) throws E1, E2, E3 {
        str = Strings.requireNonNullNorWhitespacePrivate(str, stringExceptionsCustom, StringExceptionsCustom.INSTANCE_NAME);
        return str;
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(defaultStr, new StringExceptionsDefaultWithMessage("defaultStr", "defaultStr", null));
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(defaultStr, new StringExceptionsDefaultWithMessage("defaultStr", "defaultStr", "defaultStr"));
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), new StringExceptionsDefaultWithMessage("supplier.get()", "supplier.get()", null));
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), new StringExceptionsDefaultWithMessage("supplier.get()", "supplier.get()", "supplier.get()"));
    }

    //------------------------------------------------------------------------------------------------------------------

    //PRIVATE METHODS

    private static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorEmptyPrivate(String str, StringExceptionThrower<E1, E2, E3> stringExceptionThrower, String stringExceptionThrowerInstanceName) throws E1, E2 {
        if (str == null) {
            Objects.requireNonNull(stringExceptionThrower, stringExceptionThrowerInstanceName).throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionThrower, stringExceptionThrowerInstanceName).throwEmptyStringException();
        }
        return str;
    }

    private static <E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> String requireNonNullNorWhitespacePrivate(String str, StringExceptionThrower<E1, E2, E3> stringExceptionThrower, String stringExceptionThrowerInstanceName) throws E1, E2, E3 {
        if (str == null) {
            Objects.requireNonNull(stringExceptionThrower, stringExceptionThrowerInstanceName).throwNullStringException();
        }
        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionThrower, stringExceptionThrowerInstanceName).throwEmptyStringException();
        }

        str = str.strip();

        if (str.isEmpty()) {
            Objects.requireNonNull(stringExceptionThrower, stringExceptionThrowerInstanceName).throwWhitespaceStringException();
        }
        return str;
    }
}