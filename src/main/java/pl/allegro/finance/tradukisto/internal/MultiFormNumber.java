package pl.allegro.finance.tradukisto.internal;

public class MultiFormNumber {

    private final String aloneForm;
    private final String regularForm;

    public MultiFormNumber(String aloneForm, String regularForm) {
        this.aloneForm = aloneForm;
        this.regularForm = regularForm;
    }

    public String getAloneForm() {
        return aloneForm;
    }

    public String getRegularForm() {
        return regularForm;
    }

}
