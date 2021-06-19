package myjava.util.function;

import java.util.Objects;

@FunctionalInterface
public interface TwoParameterFunctionWithThrowable<I1, I2, O> {
    O apply(I1 i1, I2 i2) throws Throwable;

    default <V> TwoParameterFunctionWithThrowable<I1, I2, V> andThen(OneParameterFunctionWithThrowable<? super O, ? extends V> after) {
        Objects.requireNonNull(after);
        return (I1 i1, I2 i2) -> after.apply(apply(i1, i2));
    }
}