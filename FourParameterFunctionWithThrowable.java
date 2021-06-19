package myjava.util.function;

import java.util.Objects;

@FunctionalInterface
public interface FourParameterFunctionWithThrowable<I1, I2, I3, I4, O> {
    O apply(I1 i1, I2 i2, I3 i3, I4 i4) throws Throwable;

    default <V> FourParameterFunctionWithThrowable<I1, I2, I3, I4, V> andThen(OneParameterFunctionWithThrowable<? super O, ? extends V> after) {
        Objects.requireNonNull(after);
        return (I1 i1, I2 i2, I3 i3, I4 i4) -> after.apply(apply(i1, i2, i3, i4));
    }
}