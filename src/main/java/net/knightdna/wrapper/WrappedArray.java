package net.knightdna.wrapper;

public class WrappedArray {

    public static Boolean[] of(boolean[] primitiveBooleans) {
        return WrappedStream.of(primitiveBooleans).toArray(Boolean[]::new);
    }

    public static Byte[] of(byte[] primitiveBytes) {
        return WrappedStream.of(primitiveBytes).toArray(Byte[]::new);
    }

    public static Character[] of(char[] primitiveChars) {
        return WrappedStream.of(primitiveChars).toArray(Character[]::new);
    }

    public static Short[] of(short[] primitiveShorts) {
        return WrappedStream.of(primitiveShorts).toArray(Short[]::new);
    }

    public static Integer[] of(int[] primitiveIntegers) {
        return WrappedStream.of(primitiveIntegers).toArray(Integer[]::new);
    }

    public static Long[] of(long[] primitiveLongs) {
        return WrappedStream.of(primitiveLongs).toArray(Long[]::new);
    }

    public static Float[] of(float[] primitiveFloats) {
        return WrappedStream.of(primitiveFloats).toArray(Float[]::new);
    }

    public static Double[] of(double[] primitiveDoubles) {
        return WrappedStream.of(primitiveDoubles).toArray(Double[]::new);
    }

}
