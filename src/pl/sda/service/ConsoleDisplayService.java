package pl.sda.service;

import pl.sda.model.Entity;
import pl.sda.model.Item;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ConsoleDisplayService {

    private final String TITLE = "Faktura VAT nr ";


    public void insertSectionIntoInvoice(char[][] invoiceTemplate, char[][] section, int x, int y) {
        insert2DimArrayInto2DimArray(invoiceTemplate, section, x, y);
    }

    public void insertDataIntoSection(char[][] section, char[][] data) {
        insert2DimArrayInto2DimArray(section, data, 2, 1);
    }

    public char[][] createInvoiceTemplate(int invoiceLength, int invoiceWidth) {
        return createEmptySection(invoiceLength, invoiceWidth);
    }

    public char[][] createItemSection(Item[] itemList, int itemSectionWidth) {
        int widthItemNameSection = (int) (0.4 * itemSectionWidth);
        int widthItemNettValueSection = (int) (0.2 * itemSectionWidth);
        int widthTaxRateSection = (int) (0.2 * itemSectionWidth);
        int widthGrossValueSection = (int) (0.2 * itemSectionWidth);
        int xName = 0;
        int xNettValue = xName + widthItemNameSection;
        int xTaxRate = xNettValue + widthItemNettValueSection;
        int xGrossValue = xTaxRate + widthTaxRateSection;
        //itemSection template
        char[][] itemSection = createEmptySection(itemList.length + 2, itemSectionWidth);
        //sections
        char[][] itemNameSection = createEmptySection(itemList.length + 2, widthItemNameSection);
        char[][] itemNettValueSection = createEmptySection(itemList.length + 2, widthItemNettValueSection);
        char[][] itemTaxRateSection = createEmptySection(itemList.length + 2, widthTaxRateSection);
        char[][] itemGrossValueSection = createEmptySection(itemList.length + 2, widthGrossValueSection);


        String[] listItemName = new String[itemList.length + 1];
        String[] listItemNettValue = new String[itemList.length + 1];
        String[] listTaxRate = new String[itemList.length + 1];
        String[] listGrossValue = new String[itemList.length + 1];

        //Headlines
        listItemName[0] = "Nazwa ";
        listItemNettValue[0] = "Cena netto";
        listTaxRate[0] = "Stawka VAT";
        listGrossValue[0] = "Cena brutto";


        //itemList to String[]
        for (int i = 1; i <= itemList.length; i++) {
            listItemName[i] = i + ". " + itemList[i - 1].getName();
            listItemNettValue[i] = itemList[i - 1].getNettValue().toString();
            listTaxRate[i] = String.valueOf(itemList[i - 1].getTaxRate()) + "%";
            listGrossValue[i] = itemList[i - 1].getGrossValue().toString();
        }
        //fill data
        fillEmptySectionWithProvidedData(listItemName, itemNameSection);
        fillEmptySectionWithProvidedData(listItemNettValue, itemNettValueSection);
        fillEmptySectionWithProvidedData(listTaxRate, itemTaxRateSection);
        fillEmptySectionWithProvidedData(listGrossValue, itemGrossValueSection);

        //insert sections to itemSection template
        insert2DimArrayInto2DimArray(itemSection, itemNameSection, xName, 0);
        insert2DimArrayInto2DimArray(itemSection, itemNettValueSection, xNettValue, 0);
        insert2DimArrayInto2DimArray(itemSection, itemTaxRateSection, xTaxRate, 0);
        insert2DimArrayInto2DimArray(itemSection, itemGrossValueSection, xGrossValue, 0);

        return itemSection;
    }

    public void display2DArray(char[][] twoDimArray) {
        for (char[] array : twoDimArray) {
            System.out.println(array);
        }
    }

    public char[][] createEmptySectionWithFrame(int sectionLength, int sectionWidth) {

        char[][] chars = createEmptySection(sectionLength, sectionWidth);
        char symbol = '*';
        //lepiej przejść 2 razy po tablicy niż w środku Tworzyć ify (warunki)
        for (int i = 0; i < sectionWidth; i++) {
            chars[0][i] = symbol;
            chars[sectionLength - 1][i] = symbol;
        }
        for (int i = 0; i < sectionLength; i++) {
            chars[i][0] = symbol;
            chars[i][sectionWidth - 1] = symbol;
        }
        return chars;
/*      //Mniej optymalne rozwiązanie - Przy dużych tablicach mamy bardzo dużo ifów tbl[x][y]  x*y = iloscIfow
        char[][] chars = new char[h][w];
        char symbolBase = '*';
        char symbol = ' ';

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (i > 0 && i < chars.length - 1 && j>0 && j<chars[i].length-1)
                    chars[i][j] = symbol;
                else
                    chars[i][j] = symbolBase;
            }
        }*/
    }

    public void fillSellerSectionWithData(char[][] section, Entity entity) {

        fillEntitySectionWithData(section, entity, true);
    }

    public void fillBuyerSectionWithData(char[][] section, Entity entity) {
        fillEntitySectionWithData(section, entity, false);
    }

    public void fillTitleSectionWithData(char[][] section, String title) {

        String[] titleData = new String[]{
                TITLE + title
        };
        fillEmptySectionWithProvidedData(titleData, section);
    }

    public void fillDataSectionWithData(char[][] section, Date data) {
        String[] dataData = new String[]{
                "Data wystawienia: " + formatData(data)
        };
        fillEmptySectionWithProvidedData(dataData, section);
    }

    public void fillTotalValiuSectionWithData(char[][] section, Double totalValue) {
        String[] data = new String[]{
                String.format("DO ZAPŁATY: %, .2f", totalValue) + " zł"
        };
        fillEmptySectionWithProvidedData(data, section);
    }

    public void createInvoiceFile(String fileName, char[][] twoDimArray) throws IOException {
        String filePath = createFolderPath() + "/" + TITLE + fileName.replaceAll("/","_") + ".txt";
        Path path = Paths.get(filePath);
        PrintStream output = new PrintStream(new File(filePath));

        for (char[] array : twoDimArray) {
            output.println(array);
        }
    }

    public void createFolder() {
        File folder = new File(createFolderPath());
        folder.mkdir();
    }

    private String createFolderPath() {
        String folderPath = ".\\src\\pl\\sda\\";
        String folderName = folderPath + "invoices";
        return folderName;
    }


    private void fillEntitySectionWithData(char[][] section, Entity entity, boolean isSeller) {
        String postalCode = entity.getAddress().getPostalCode().getValue();
        String city = entity.getAddress().getCity();
        String street = entity.getAddress().getStreet();
        String buldingNumber = entity.getAddress().getBuildingNumber();
        String apartmentNumber = String.valueOf(entity.getAddress().getApartamentNumber());
        String lastValue;
        if (isSeller) {
            lastValue = "Nr konta: " + entity.getAccountNumber().getValue();
        } else {

            lastValue = "Termin zapłaty: " + formatData(entity.getPaymentDay());
        }
        String[] entityData = new String[]{
                entity.getCompanyName(),
                postalCode + " " + city + ", ul." + street + " " + buldingNumber + " " + apartmentNumber,
                "NIP: " + entity.getNip().getValue(),
                lastValue
        };

        fillEmptySectionWithProvidedData(entityData, section);

    }


    private void fillEmptySectionWithProvidedData(String[] data, char[][] section) {//sekcja > niz data inaczej bedzie blad - trzeba zabezpieczyc
        //data->String[] -> char[][]
        int maxLenght = 0;
        for (String line : data) {
            if (maxLenght < line.length()) {
                maxLenght = line.length();
            }
        }
//      char[][]section = createEmptySectionWithFrame(data.length+2,maxLenght+4);
        char[][] dataCharacters = createEmptySection(data.length, maxLenght);

        for (int i = 0; i < data.length; i++) {
            dataCharacters[i] = data[i].toCharArray();
        }
        insertDataIntoSection(section, dataCharacters);
        //display2DArray(section);
    }


    private void insert2DimArrayInto2DimArray(char[][] bigArray, char[][] smallArray, int x, int y) {
        for (int i = 0; i < smallArray.length; i++) {
            System.arraycopy(smallArray[i], 0, bigArray[i + y], x, smallArray[i].length);
        }

    }
    //wyjaśnienie działania funkcji System.arraycopy
   /* public void insert2DimArrayInto2DimArray(char[][] invoiceTemplate, char[][] section, int x, int y) {
    for (int i = 0; i < section.length; i++) {
        for (int j = 0; j < section[i].length; j++) {
            invoiceTemplate[i + y][j + x] = section[i][j];
        }
    }
}*/
    // koniec wyjasnienia

    private char[][] createEmptySection(int sectionLength, int sectionWidth) {
        char[][] chars = new char[sectionLength][sectionWidth];
        char emptySymbol = ' ';

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = emptySymbol;
            }
        }
        return chars;
    }

    private String formatData(Date data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        return simpleDateFormat.format(data);
    }
}
