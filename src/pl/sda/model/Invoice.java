package pl.sda.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Invoice {


    private static int counterInvoice = 0;
    private Date issueDate;

    private String title;
    private Entity seller;
    private Entity buyer;
    private Item[] itemList;
    private Double totalValue;
    private String totalValueWritten;

    public Invoice(Entity seller, Entity buyer, Item[] itemList) {
        this.seller = seller;
        this.buyer = buyer;
        this.itemList = itemList;
        this.issueDate = createIssueDate();
        this.totalValue = calculateTotalValue();
        counterInvoice++;
        this.title = calculateTitle();
    }

    public static int getCounterInvoice() {
        return counterInvoice;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getTitle() {
        return title;
    }

    public Entity getSeller() {
        return seller;
    }

    public Entity getBuyer() {
        return buyer;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public String getTotalValueWritten() {
        return totalValueWritten;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "\nissueDate=" + issueDate +
                "\n, title='" + title + '\'' +
                "\n, seller=" + seller +
                "\n, buyer=" + buyer +
                "\n, itemList=" + Arrays.toString(itemList) +
                "\n, totalValue=" + totalValue +
                "\n, totalValueWritten='" + totalValueWritten + '\'' +
                '}';
    }

    private Date createIssueDate() {
        return new Date();
    }


    private Double calculateTotalValue() {
        Double totalValue = 0D;
        for (int i = 0; i < getItemList().length; i++) {
            totalValue += getItemList()[i].getGrossValue();
        }
        return totalValue;
    }
    private String calculateTitle() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/YY");
        return counterInvoice + "/" + simpleDateFormat.format(issueDate) ;
    }
}
