package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;
import myjava.util.StringExceptionsValidationMessages;

import java.util.Objects;
import java.util.function.Supplier;

public record StringExceptionsCustom<E1 extends Throwable, E2 extends Throwable, E3 extends Throwable>
        (Supplier<E1> nullStringParam, Supplier<E2> emptyStringParam, Supplier<E3> whitespaceStringParam)
        implements
            StringExceptionRecordGetter<Supplier<E1>, Supplier<E2>, Supplier<E3>>,
            StringExceptionThrower<E1, E2, E3> {

    @Override
    public void throwNullStringException() throws E1 {
        Objects.requireNonNull(nullStringParam, StringExceptionsValidationMessages.CUSTOM.nullStringParam);
        throw Objects.requireNonNull(nullStringParam.get(), StringExceptionsValidationMessages.CUSTOM.nullStringParamGet);
    }

    @Override
    public void throwEmptyStringException() throws E2 {
        Objects.requireNonNull(emptyStringParam, StringExceptionsValidationMessages.CUSTOM.emptyStringParam);
        throw Objects.requireNonNull(emptyStringParam.get(), StringExceptionsValidationMessages.CUSTOM.emptyStringParamGet);
    }

    @Override
    public void throwWhitespaceStringException() throws E3 {
        Objects.requireNonNull(whitespaceStringParam, StringExceptionsValidationMessages.CUSTOM.whitespaceStringParam);
        throw Objects.requireNonNull(whitespaceStringParam.get(), StringExceptionsValidationMessages.CUSTOM.whitespaceStringParamGet);
    }
}