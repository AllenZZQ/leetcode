package util;

public class Tuple {

    public static class TwoTuple<A, B> {
        public final A first;

        public final B second;

        public TwoTuple(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public static class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

        public final C third;

        public ThreeTuple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }
    }

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }

}
