package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;
import myjava.util.StringExceptionsValidationMessages;

import java.util.Objects;

public record StringExceptionsDefaultWithMessage
        (String nullStringParam, String emptyStringParam, String whitespaceStringParam)
        implements
            StringExceptionRecordGetter<String, String, String>,
            StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {

    @Override
    public void throwNullStringException() throws NullPointerException {
        Objects.requireNonNull(nullStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE.nullStringParam);
        throw new NullPointerException(nullStringParam);
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        Objects.requireNonNull(emptyStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE.emptyStringParam);
        throw new IllegalArgumentException(emptyStringParam);
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        Objects.requireNonNull(whitespaceStringParam, StringExceptionsValidationMessages.DEFAULT_WITH_MESSAGE.whitespaceStringParam);
        throw new IllegalArgumentException(whitespaceStringParam);
    }
}