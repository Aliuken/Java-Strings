package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;

import java.util.Objects;
import java.util.function.Supplier;

public record StringExceptionsDefaultWithMessageSupplier
        (Supplier<String> nullStringParam, Supplier<String> emptyStringParam, Supplier<String> whitespaceStringParam)
        implements
            StringExceptionRecordGetter<Supplier<String>, Supplier<String>, Supplier<String>>,
            StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {

    public static final String INSTANCE_NAME = "stringExceptionsDefaultWithMessageSupplier";

    @Override
    public void throwNullStringException() throws NullPointerException {
        Objects.requireNonNull(nullStringParam, INSTANCE_NAME + ".nullStringParam");
        throw new NullPointerException(Objects.requireNonNull(nullStringParam.get(), INSTANCE_NAME + ".nullStringParam.get()"));
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        Objects.requireNonNull(emptyStringParam, INSTANCE_NAME + ".emptyStringParam");
        throw new IllegalArgumentException(Objects.requireNonNull(emptyStringParam.get(), INSTANCE_NAME + ".emptyStringParam.get()"));
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        Objects.requireNonNull(whitespaceStringParam, INSTANCE_NAME + ".whitespaceStringParam");
        throw new IllegalArgumentException(Objects.requireNonNull(whitespaceStringParam.get(), INSTANCE_NAME + ".whitespaceStringParam.get()"));
    }
}