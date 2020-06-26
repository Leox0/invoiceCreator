package pl.sda.model;

public class AccountNumber {
    private String value;

    public AccountNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AccountNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
