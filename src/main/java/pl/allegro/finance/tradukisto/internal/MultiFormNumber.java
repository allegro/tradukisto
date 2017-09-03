package pl.allegro.finance.tradukisto.internal;

public class MultiFormNumber {

    private String aloneForm;
    private String regularForm;

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
