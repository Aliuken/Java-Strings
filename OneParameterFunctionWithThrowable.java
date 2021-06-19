package myjava.util.function;

import java.util.Objects;

@FunctionalInterface
public interface OneParameterFunctionWithThrowable<I, O> {
    O apply(I i) throws Throwable;

    default <V> OneParameterFunctionWithThrowable<V, O> compose(OneParameterFunctionWithThrowable<? super V, ? extends I> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> OneParameterFunctionWithThrowable<I, V> andThen(OneParameterFunctionWithThrowable<? super O, ? extends V> after) {
        Objects.requireNonNull(after);
        return (I i) -> after.apply(apply(i));
    }

    static <T> OneParameterFunctionWithThrowable<T, T> identity() {
        return t -> t;
    }
}