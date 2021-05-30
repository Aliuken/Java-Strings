package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;

import java.util.Objects;

public record StringExceptionsDefaultWithMessage
        (String nullStringParam, String emptyStringParam, String whitespaceStringParam)
        implements
            StringExceptionRecordGetter<String, String, String>,
            StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {

    public static final String INSTANCE_NAME = "stringExceptionsDefaultWithMessage";

    @Override
    public void throwNullStringException() throws NullPointerException {
        Objects.requireNonNull(nullStringParam, INSTANCE_NAME + ".nullStringParam");
        throw new NullPointerException(nullStringParam);
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        Objects.requireNonNull(emptyStringParam, INSTANCE_NAME + ".emptyStringParam");
        throw new IllegalArgumentException(emptyStringParam);
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        Objects.requireNonNull(whitespaceStringParam, INSTANCE_NAME + ".whitespaceStringParam");
        throw new IllegalArgumentException(whitespaceStringParam);
    }
}