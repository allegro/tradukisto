package pl.allegro.finance.tradukisto.internal.support;

public class Range<N extends Number & Comparable<N>> {

    private final N start;
    private final N end;

    private Range(N start, N end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(N value) {
        return start.compareTo(value) <= 0
                && value.compareTo(end) <= 0;
    }

    public static <N extends Number & Comparable<N>> Range<N> closed(N start, N end) {
        return new Range<>(start, end);
    }
}
