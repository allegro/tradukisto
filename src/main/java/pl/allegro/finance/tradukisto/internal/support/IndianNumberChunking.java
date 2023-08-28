package pl.allegro.finance.tradukisto.internal.support;

import java.util.LinkedList;
import java.util.List;

public class IndianNumberChunking extends NumberChunking{

    private static final int INDAIN_SPLIT_FACTOR = 1_00;

    @Override
    public List<Integer> chunk(Long value) {
        int splitCounter = 0;
        LinkedList<Integer> result = new LinkedList<>();

        while (value > 0) {
            if (splitCounter < 1) {
                result.addFirst((int) (value % SPLIT_FACTOR));
                value /= SPLIT_FACTOR;
                splitCounter++;
            } else {
                result.addFirst((int) (value % INDAIN_SPLIT_FACTOR));
                value /= INDAIN_SPLIT_FACTOR;
                splitCounter++;
            }

        }

        return result;
    }

}
