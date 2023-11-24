package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class JapaneseNumberChunking extends NumberChunking {
    
    private static final int JAPANESE_SPLIT_FACTOR = 1_0000;

    @Override
    public List<Integer> chunk(Long value) {
        LinkedList<Integer> result = new LinkedList<>();

        while (value > 0) {
            result.addFirst((int) (value % JAPANESE_SPLIT_FACTOR));
            value /= JAPANESE_SPLIT_FACTOR;
        }

        return result;
    }
}
