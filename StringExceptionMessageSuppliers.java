package myjava.util;

import java.util.Objects;
import java.util.function.Supplier;

public record StringExceptionMessageSuppliers(Supplier<String> nullStringParam, Supplier<String> emptyStringParam, Supplier<String> whitespaceStringParam) implements StringExceptionRecordGetter<Supplier<String>, Supplier<String>, Supplier<String>>, StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {
    private String nullStringExceptionMessage() {
        return Objects.requireNonNull(nullStringParam, "stringExceptionMessageSuppliers.nullStringParam").get();
    }

    private String emptyStringExceptionMessage() {
        return Objects.requireNonNull(emptyStringParam, "stringExceptionMessageSuppliers.emptyStringParam").get();
    }

    private String whitespaceStringExceptionMessage() {
        return Objects.requireNonNull(whitespaceStringParam, "stringExceptionMessageSuppliers.whitespaceStringParam").get();
    }

    @Override
    public void throwNullStringException() throws NullPointerException {
        throw new NullPointerException(Objects.requireNonNull(nullStringExceptionMessage(), "stringExceptionMessageSuppliers.nullStringParam.get()"));
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Objects.requireNonNull(emptyStringExceptionMessage(), "stringExceptionMessageSuppliers.emptyStringParam.get()"));
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Objects.requireNonNull(whitespaceStringExceptionMessage(), "stringExceptionMessageSuppliers.whitespaceStringParam.get()"));
    }
}
