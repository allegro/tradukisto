package pl.allegro.finance.tradukisto.internal.languages;

public class MissingFormException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    MissingFormException(String message) {
        super(message);
    }
}
