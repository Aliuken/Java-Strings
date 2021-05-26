package myjava.util.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunctionWithThrowable<T, U, V, R> {

    R apply(T t, U u, V v) throws Throwable;

    default <R2> TriFunctionWithThrowable<T, U, V, R2> andThen(Function<? super R, ? extends R2> after) {
        Objects.requireNonNull(after);
        return (T t, U u, V v) -> after.apply(apply(t, u, v));
    }
}