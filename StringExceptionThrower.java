package myjava.util;

public interface StringExceptionThrower<E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> {
    void throwNullStringException() throws E1;
    void throwEmptyStringException() throws E2;
    void throwWhitespaceStringException() throws E3;
}