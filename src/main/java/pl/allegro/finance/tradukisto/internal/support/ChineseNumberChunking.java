package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class ChineseNumberChunking extends NumberChunking {
    private static final int CHINESE_SPLIT_FACTOR = 1_0000;

    public List<Integer> chunk(Long value) {
        LinkedList<Integer> result = new LinkedList<>();

        while (value > 0) {
            result.addFirst((int) (value % CHINESE_SPLIT_FACTOR));
            value /= CHINESE_SPLIT_FACTOR;
        }

        return result;
    }
}
