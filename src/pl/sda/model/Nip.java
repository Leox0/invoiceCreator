package pl.sda.model;

public class Nip {
    private String value;

    public Nip(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Nip{" +
                "value='" + value + '\'' +
                '}';
    }
}
