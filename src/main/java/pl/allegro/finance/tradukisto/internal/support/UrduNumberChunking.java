package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class UrduNumberChunking extends NumberChunking {
    private static final int URDU_SPLIT_FACTOR = 100;

    @Override
    public List<Integer> chunk(Long value) {
        LinkedList<Integer> result = new LinkedList<>();

        result.add((int) (value % SPLIT_FACTOR));

        long v = value / SPLIT_FACTOR;

        while (v > 0) {
            result.addFirst((int) (v % URDU_SPLIT_FACTOR));
            v /= URDU_SPLIT_FACTOR;
        }
        return result;
    }
}
