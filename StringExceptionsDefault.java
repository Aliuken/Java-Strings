package myjava.util.records;

import myjava.util.StringExceptionRecordGetter;
import myjava.util.StringExceptionThrower;

public record StringExceptionsDefault
        (Void nullStringParam, Void emptyStringParam, Void whitespaceStringParam)
        implements
            StringExceptionRecordGetter<Void, Void, Void>,
            StringExceptionThrower<NullPointerException, IllegalArgumentException, IllegalArgumentException> {

    @Override
    public void throwNullStringException() throws NullPointerException {
        throw new NullPointerException();
    }

    @Override
    public void throwEmptyStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    @Override
    public void throwWhitespaceStringException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}