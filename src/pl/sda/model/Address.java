package pl.sda.model;

public class Address {
    private PostalCode postalCode;
    private String city;
    private String street;
    private String buildingNumber;
    private short apartamentNumber;

    public Address(PostalCode postalCode, String city, String street, String buildingNumber, short apartamentNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartamentNumber = apartamentNumber;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public short getApartamentNumber() {
        return apartamentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartamentNumber=" + apartamentNumber +
                '}';
    }
}
