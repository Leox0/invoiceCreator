package pl.sda.model;

public class Item {
    private String name;
    private Double nettValue;
    private short taxRate;
    private Double grossValue;

    public Item(String name, Double nettValue, short taxRate) {
        this.name = name;
        this.nettValue = nettValue;
        this.taxRate = taxRate;
        this.grossValue = calculateGrossValue();
    }


    public String getName() {
        return name;
    }

    public Double getNettValue() {
        return nettValue;
    }

    public short getTaxRate() {
        return taxRate;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    @Override
    public String toString() {
        return "\n      Item{" +
                "name='" + name + '\'' +
                ", nettValie=" + nettValue +
                ", taxRate=" + taxRate +
                ", grossValue=" + grossValue +
                '}';
    }

    private Double calculateGrossValue() {
        return (getNettValue() * getTaxRate() / 100) + getNettValue();
    }

}
