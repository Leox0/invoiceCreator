package pl.sda;

import pl.sda.model.*;
import pl.sda.service.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsoleInputDataService consoleInputDataService = new ConsoleInputDataService();
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        Invoice invoice = consoleInputDataService.invoiceStub();
//      tworzymy pustą fakturę
        char[][] invoiceTemplate = consoleDisplayService.createInvoiceTemplate(33, 100);

//      tworzymy puste sekcje
        char[][] dataFrame = consoleDisplayService.createEmptySectionWithFrame(3, 35);
        char[][] sellerFrame = consoleDisplayService.createEmptySectionWithFrame(6, 40);
        char[][] buyerFrame = consoleDisplayService.createEmptySectionWithFrame(6, 40);
        char[][] titleSection = consoleDisplayService.createInvoiceTemplate(2,30);
        char[][] itemSection = consoleDisplayService.createItemSection(invoice.getItemList(),80);
        char[][] totalValueSection = consoleDisplayService.createInvoiceTemplate(2,30);
        consoleDisplayService.fillDataSectionWithData(dataFrame, invoice.getIssueDate());
        consoleDisplayService.fillSellerSectionWithData(sellerFrame, invoice.getSeller());
        consoleDisplayService.fillBuyerSectionWithData(buyerFrame, invoice.getBuyer());
        consoleDisplayService.fillTitleSectionWithData(titleSection, invoice.getTitle());
        consoleDisplayService.fillTotalValiuSectionWithData(totalValueSection, invoice.getTotalValue());

//        wklejamy sekcje
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, dataFrame, 0, 0);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, sellerFrame, 0, 10);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, buyerFrame, 50, 10);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, titleSection, 30, 7);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemSection, 0, 17);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, totalValueSection, 0, 28);
        consoleDisplayService.display2DArray(invoiceTemplate);



      /*  Scanner s = new Scanner(System.in);
        Tmp tmp = new Tmp();

        //dodatkowe 1
        System.out.println(tmp.countDigits(1234L));
        //dodatkowe 2
        tmp.primeFactorDistribution(12);
        System.out.println("\n###########");
        //zad 1.
        String postalCode;
        boolean correct = false;
        while (!correct) {
            System.out.println("Podaj kod:");
            postalCode = s.nextLine();
            correct = tmp.validatePostalCode(new PostalCode(postalCode));
        }

        //zad 2.
        String nip;
        correct = false;
        while (!correct) {
            System.out.println("Podaj nip:");
            nip = s.nextLine();
            correct = tmp.validateNip(new Nip(nip));
        }

        //zad 3.
        String accountNumber;
        correct = false;
        while (!correct) {
            System.out.println("Podaj numer konta:");
            accountNumber = s.nextLine();
            correct = tmp.validateAccountNumber(new AccountNumber(accountNumber));
        }*/


    }

}
