package net.knightdna.wrapper;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Shorts;

import java.util.Arrays;
import java.util.stream.Stream;

public class WrappedStream {

    public static Stream<Boolean> of(boolean[] primitiveBooleans) {
        return Booleans.asList(primitiveBooleans).stream();
    }

    public static Stream<Byte> of(byte[] primitiveBytes) {
        return Bytes.asList(primitiveBytes).stream();
    }

    public static Stream<Character> of(char[] primitiveChars) {
        return Chars.asList(primitiveChars).stream();
    }

    public static Stream<Short> of(short[] primitiveShorts) {
        return Shorts.asList(primitiveShorts).stream();
    }

    public static Stream<Integer> of(int[] primitiveIntegers) {
        return Arrays.stream(primitiveIntegers).boxed();
    }

    public static Stream<Long> of(long[] primitiveLongs) {
        return Arrays.stream(primitiveLongs).boxed();
    }

    public static Stream<Float> of(float[] primitiveFloats) {
        return Floats.asList(primitiveFloats).stream();
    }

    public static Stream<Double> of(double[] primitiveDoubles) {
        return Arrays.stream(primitiveDoubles).boxed();
    }

}
