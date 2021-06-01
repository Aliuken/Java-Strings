package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;
import myjava.util.StringExceptionsValidationMessages;

import java.util.Objects;
import java.util.function.Supplier;

public final record StringExceptionsDefaultWithMessageSupplier
        (Supplier<String> nullStringParam, Supplier<String> emptyStringParam, Supplier<String> whitespaceStringParam)
        implements
            StringExceptionRecordGetter<Supplier<String>, Supplier<String>, Supplier<String>>,
            StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {

    @Override
    public void throwNullStringException() throws NullPointerException {
        Objects.requireNonNull(nullStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.nullStringParam);
        throw new NullPointerException(Objects.requireNonNull(nullStringParam.get(), StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.nullStringParamGet));
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        Objects.requireNonNull(emptyStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.emptyStringParam);
        throw new IllegalArgumentException(Objects.requireNonNull(emptyStringParam.get(), StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.emptyStringParamGet));
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        Objects.requireNonNull(whitespaceStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.whitespaceStringParam);
        throw new IllegalArgumentException(Objects.requireNonNull(whitespaceStringParam.get(), StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE_SUPPLIER.whitespaceStringParamGet));
    }
}