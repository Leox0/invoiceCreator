package pl.sda.service;

import pl.sda.model.*;

import java.util.Date;

public class ConsoleInputDataService {
    public Invoice invoiceStub() {

        //dane sprzedawcy
        PostalCode sellerPostalCode = new PostalCode("91-222");
        Address sellerAddress = new Address(sellerPostalCode, "Lodz", "Wodna", "13a", (short) 23);
        Nip sellerNip = new Nip("1234567819");
        AccountNumber sellerAccountNumber = new AccountNumber("34325454545442342366336985");
        Entity seller = new Entity("JanuszPol", sellerAddress, sellerNip, sellerAccountNumber, new Date());

        //dane kupujacego
        PostalCode buyerPostalCode = new PostalCode("91-333");
        Address buyerAddress = new Address(buyerPostalCode, "Ozorków", "Gorkiego", "132", (short) 2);
        Nip buyerNip = new Nip("1234567819");
        AccountNumber buyerAccountNumber = new AccountNumber("4569874521658746932584569");
        Entity buyer = new Entity("Januszex", buyerAddress, buyerNip, buyerAccountNumber, new Date());

        //tworzymy liste uslug i produktow
//        Item[] items = new Item[4];
//        items[0] = new Item("komputer",2000L,(short)23);

        Item[] items = new Item[]{
                new Item("Komputer",4000D,(short)23),
                new Item("Procesor",530D, (short)23),
                new Item("Klawiatura",500D,(short)23),
                new Item("Czyszczenie spr. powietrzem",300D,(short)8),
        };

        return new Invoice(seller, buyer, items);

    }    public Invoice invoiceStub2() {

        //dane sprzedawcy
        PostalCode sellerPostalCode = new PostalCode("91-222");
        Address sellerAddress = new Address(sellerPostalCode, "Lodz", "Wodna", "13a", (short) 23);
        Nip sellerNip = new Nip("1234567819");
        AccountNumber sellerAccountNumber = new AccountNumber("34325454545442342366336985");
        Entity seller = new Entity("JanuszPol", sellerAddress, sellerNip, sellerAccountNumber, new Date());

        //dane kupujacego
        PostalCode buyerPostalCode = new PostalCode("91-333");
        Address buyerAddress = new Address(buyerPostalCode, "Ozorków", "Gorkiego", "132", (short) 2);
        Nip buyerNip = new Nip("1234567819");
        AccountNumber buyerAccountNumber = new AccountNumber("4569874521658746932584569");
        Entity buyer = new Entity("Januszex", buyerAddress, buyerNip, buyerAccountNumber, new Date());

        //tworzymy liste uslug i produktow
//        Item[] items = new Item[4];
//        items[0] = new Item("komputer",2000L,(short)23);

        Item[] items = new Item[]{
                new Item("Cygara",4000D,(short)23),
                new Item("Tytoń",530D, (short)23),
                new Item("Obicnaczka",500D,(short)23),
                new Item("Filtry",300D,(short)8),
        };

        return new Invoice(seller, buyer, items);
    }
}
