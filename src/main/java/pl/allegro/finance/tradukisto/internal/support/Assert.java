package pl.allegro.finance.tradukisto.internal.support;

import java.util.function.Supplier;

public class Assert {

    public static void isFalse(boolean condition) {
        if (condition) {
            throw new IllegalArgumentException();
        }
    }

    public static void isTrue(boolean condition, Supplier<String> errorMsg) {
        if (!condition) {
            throw new IllegalArgumentException(errorMsg.get());
        }
    }

}
