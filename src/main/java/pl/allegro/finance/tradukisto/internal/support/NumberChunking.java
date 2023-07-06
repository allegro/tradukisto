package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class NumberChunking {

    private static final int SPLIT_FACTOR = 1_000;

    public List<Integer> chunk(Long value) {
        LinkedList<Integer> result = new LinkedList<>();

        while (value > 0) {
            result.addFirst((int) (value % SPLIT_FACTOR));
            value /= SPLIT_FACTOR;
        }

        return result;
    }
}
