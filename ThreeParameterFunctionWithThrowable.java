package myjava.util.function;

import java.util.Objects;

@FunctionalInterface
public interface ThreeParameterFunctionWithThrowable<I1, I2, I3, O> {
    O apply(I1 i1, I2 i2, I3 i3) throws Throwable;

    default <V> ThreeParameterFunctionWithThrowable<I1, I2, I3, V> andThen(OneParameterFunctionWithThrowable<? super O, ? extends V> after) {
        Objects.requireNonNull(after);
        return (I1 i1, I2 i2, I3 i3) -> after.apply(apply(i1, i2, i3));
    }
}