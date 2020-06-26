package pl.sda.additional.tree;

import pl.sda.service.ConsoleDisplayService;

public class Tree {
    static ConsoleDisplayService display = new ConsoleDisplayService();


    public char[][] createTreeTemplate(int counterTriangles) {

        char[][] invoiceTemplate = display.createInvoiceTemplate(counterTriangles, 2 * counterTriangles - 1);
        return invoiceTemplate;
    }

        public char[][] createTreeSector(int x){
       return display.createInvoiceTemplate(x,2*x-1);
    }


    public char[][] createTreeTriangle(int x){
        char[][] chars = createTreeSector(x);
        char symbol = '*';




        return chars;
    }


    public char[][] tree(int x) {

        char[][] tree = new char[x][2 * x - 1];

        for (int j = 1; j <= x; j++) {
            for (int i = x; i > j; i--) {
                System.out.print("@");
            }
            for (int i = 1; i <= j; i++) {
                System.out.print("* ");
            }
            System.out.println();

        }
        return tree;
    }

}

