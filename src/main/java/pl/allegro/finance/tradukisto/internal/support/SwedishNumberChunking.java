package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class SwedishNumberChunking extends NumberChunking {

    static final int THOUSANDS_SPLIT_FACTOR = 1_000_000;
    static final int SPLIT_FACTOR = 1_000;

    public List<Integer> chunk(Long value) {
        LinkedList<Integer> result = new LinkedList<>();

        Integer thousands = (int) (value % THOUSANDS_SPLIT_FACTOR);

        while (value > 1000000000000L)
            value /= SPLIT_FACTOR;

        while (value > 0) {
            result.addFirst((int) (value % SPLIT_FACTOR));
            value /= SPLIT_FACTOR;
        }

        return result;
    }
}
