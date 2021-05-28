package myjava.util;

import java.util.Objects;
import java.util.function.Supplier;

public record StringExceptionSuppliers<E1 extends Throwable, E2 extends Throwable, E3 extends Throwable>(Supplier<? extends E1> nullStringParam, Supplier<? extends E2> emptyStringParam, Supplier<? extends E3> whitespaceStringParam) implements StringExceptionRecordGetter<Supplier<? extends E1>, Supplier<? extends E2>, Supplier<? extends E3>>, StringExceptionThrower<E1, E2, E3> {
    private E1 nullStringException() {
        return Objects.requireNonNull(nullStringParam, "stringExceptionSuppliers.nullStringParam").get();
    }

    private E2 emptyStringException() {
        return Objects.requireNonNull(emptyStringParam, "stringExceptionSuppliers.emptyStringParam").get();
    }

    private E3 whitespaceStringException() {
        return Objects.requireNonNull(whitespaceStringParam, "stringExceptionSuppliers.whitespaceStringParam").get();
    }

    @Override
    public void throwNullStringException() throws E1 {
        throw Objects.requireNonNull(nullStringException(), "stringExceptionSuppliers.nullStringParam.get()");
    }

    @Override
    public void throwEmptyStringException() throws E2 {
        throw Objects.requireNonNull(emptyStringException(), "stringExceptionSuppliers.emptyStringParam.get()");
    }

    @Override
    public void throwWhitespaceStringException() throws E3 {
        throw Objects.requireNonNull(whitespaceStringException(), "stringExceptionSuppliers.whitespaceStringParam.get()");
    }
}
