package myjava.util;

import java.util.Objects;

public record StringExceptionMessages(String nullStringParam, String emptyStringParam, String whitespaceStringParam) implements StringExceptionRecordGetter<String, String, String>, StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {
    @Override
    public void throwNullStringException() throws NullPointerException {
        throw new NullPointerException(Objects.requireNonNull(nullStringParam, "stringExceptionMessages.nullStringParam"));
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Objects.requireNonNull(emptyStringParam, "stringExceptionMessages.emptyStringParam"));
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Objects.requireNonNull(whitespaceStringParam, "stringExceptionMessages.whitespaceStringParam"));
    }
}
