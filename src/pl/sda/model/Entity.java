package pl.sda.model;

import java.util.Date;

public class Entity {
    private String companyName;
    private Address address;
    private Nip nip;
    private AccountNumber accountNumber;
    private Date paymentDay;

    public Entity(String companyName, Address address, Nip nip, AccountNumber accountNumber, Date paymentDay) {
        this.companyName = companyName;
        this.address = address;
        this.nip = nip;
        this.accountNumber = accountNumber;
        this.paymentDay = paymentDay;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Address getAddress() {
        return address;
    }

    public Nip getNip() {
        return nip;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Date getPaymentDay() {
        return paymentDay;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "companyName='" + companyName + '\'' +
                ", address=" + address +
                ", nip=" + nip +
                ", accountNumber=" + accountNumber +
                ", paymentDay=" + paymentDay +
                '}';
    }
}
