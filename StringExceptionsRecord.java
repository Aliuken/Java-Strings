package myjava.util;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final record StringExceptionsRecord(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
    private static final Supplier<Throwable> LAMBDA_DEFAULT_NULL = () -> new NullPointerException();
    private static final Supplier<Throwable> LAMBDA_DEFAULT_EMPTY = () -> new IllegalArgumentException();
    private static final Supplier<Throwable> LAMBDA_DEFAULT_WHITESPACE = () -> new IllegalArgumentException();

    private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_NULL = (String nullStringMessage) -> {
        return () -> new NullPointerException(Objects.requireNonNull(nullStringMessage, "nullStringMessage"));
    };
    private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_EMPTY = (String emptyStringMessage) -> {
        return () -> new IllegalArgumentException(Objects.requireNonNull(emptyStringMessage, "emptyStringMessage"));
    };
    private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_WHITESPACE = (String whitespaceStringMessage) -> {
        return () -> new IllegalArgumentException(Objects.requireNonNull(whitespaceStringMessage, "whitespaceStringMessage"));
    };

    private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_NULL = (Supplier<String> nullStringMessageSupplier) -> {
        return () -> {
            Objects.requireNonNull(nullStringMessageSupplier, "nullStringMessageSupplier");
            return new NullPointerException(Objects.requireNonNull(nullStringMessageSupplier.get(), "nullStringMessageSupplier.get()"));
        };
    };
    private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_EMPTY = (Supplier<String> emptyStringMessageSupplier) -> {
        return () -> {
            Objects.requireNonNull(emptyStringMessageSupplier, "emptyStringMessageSupplier");
            return new IllegalArgumentException(Objects.requireNonNull(emptyStringMessageSupplier.get(), "emptyStringMessageSupplier.get()"));
        };
    };
    private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_WHITESPACE = (Supplier<String> whitespaceStringMessageSupplier) -> {
        return () -> {
            Objects.requireNonNull(whitespaceStringMessageSupplier, "whitespaceStringMessageSupplier");
            return new IllegalArgumentException(Objects.requireNonNull(whitespaceStringMessageSupplier.get(), "whitespaceStringMessageSupplier.get()"));
        };
    };

    private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_NULL = (Supplier<Throwable> nullStringThrowableSupplier) -> {
        return () -> {
            Objects.requireNonNull(nullStringThrowableSupplier, "nullStringThrowableSupplier");
            return Objects.requireNonNull(nullStringThrowableSupplier.get(), "nullStringThrowableSupplier.get()");
        };
    };
    private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_EMPTY = (Supplier<Throwable> emptyStringThrowableSupplier) -> {
        return () -> {
            Objects.requireNonNull(emptyStringThrowableSupplier, "emptyStringThrowableSupplier");
            return Objects.requireNonNull(emptyStringThrowableSupplier.get(), "emptyStringThrowableSupplier.get()");
        };
    };
    private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_WHITESPACE = (Supplier<Throwable> whitespaceStringThrowableSupplier) -> {
        return () -> {
            Objects.requireNonNull(whitespaceStringThrowableSupplier, "whitespaceStringThrowableSupplier");
            return Objects.requireNonNull(whitespaceStringThrowableSupplier.get(), "whitespaceStringThrowableSupplier.get()");
        };
    };

    public static StringExceptionsRecord createByDefault() {
        return new StringExceptionsRecord(
                LAMBDA_DEFAULT_NULL,
                LAMBDA_DEFAULT_EMPTY,
                LAMBDA_DEFAULT_WHITESPACE);
    }

    public static StringExceptionsRecord createFromMessages(String nullStringMessage, String emptyStringMessage, String whitespaceStringMessage) {
        return new StringExceptionsRecord(
                LAMBDA_DEFAULT_WITH_MESSAGE_NULL.apply(nullStringMessage),
                LAMBDA_DEFAULT_WITH_MESSAGE_EMPTY.apply(emptyStringMessage),
                LAMBDA_DEFAULT_WITH_MESSAGE_WHITESPACE.apply(whitespaceStringMessage));
    }

    public static StringExceptionsRecord createFromMessageSuppliers(Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, Supplier<String> whitespaceStringMessageSupplier) {
        return new StringExceptionsRecord(
                LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_NULL.apply(nullStringMessageSupplier),
                LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_EMPTY.apply(emptyStringMessageSupplier),
                LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_WHITESPACE.apply(whitespaceStringMessageSupplier));
    }

    public static StringExceptionsRecord createFromThrowableSuppliers(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
        return new StringExceptionsRecord(
                LAMBDA_CUSTOM_NULL.apply(nullStringThrowableSupplier),
                LAMBDA_CUSTOM_EMPTY.apply(emptyStringThrowableSupplier),
                LAMBDA_CUSTOM_WHITESPACE.apply(whitespaceStringThrowableSupplier));
    }

    public StringExceptionsRecord(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
        this.nullStringThrowableSupplier = nullStringThrowableSupplier;
        this.emptyStringThrowableSupplier = emptyStringThrowableSupplier;
        this.whitespaceStringThrowableSupplier = whitespaceStringThrowableSupplier;
    }

    public static String requireNonNull(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        return str;
    }

    public static String requireNonNullNorEmpty(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").emptyStringThrowableSupplier.get();
        }
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").emptyStringThrowableSupplier.get();
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").whitespaceStringThrowableSupplier.get();
        }
        return str;
    }
}