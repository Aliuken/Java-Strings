package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;

import java.util.Objects;
import java.util.function.Supplier;

public record StringExceptionsCustom<E1 extends Throwable, E2 extends Throwable, E3 extends Throwable>
        (Supplier<E1> nullStringParam, Supplier<E2> emptyStringParam, Supplier<E3> whitespaceStringParam)
        implements
            StringExceptionRecordGetter<Supplier<E1>, Supplier<E2>, Supplier<E3>>,
            StringExceptionThrower<E1, E2, E3> {

    public static final String INSTANCE_NAME = "stringExceptionsCustom";

    @Override
    public void throwNullStringException() throws E1 {
        Objects.requireNonNull(nullStringParam, INSTANCE_NAME + ".nullStringParam");
        throw Objects.requireNonNull(nullStringParam.get(), INSTANCE_NAME + ".nullStringParam.get()");
    }

    @Override
    public void throwEmptyStringException() throws E2 {
        Objects.requireNonNull(emptyStringParam, INSTANCE_NAME + ".emptyStringParam");
        throw Objects.requireNonNull(emptyStringParam.get(), INSTANCE_NAME + ".emptyStringParam.get()");
    }

    @Override
    public void throwWhitespaceStringException() throws E3 {
        Objects.requireNonNull(whitespaceStringParam, INSTANCE_NAME + ".whitespaceStringParam");
        throw Objects.requireNonNull(whitespaceStringParam.get(), INSTANCE_NAME + ".whitespaceStringParam.get()");
    }
}