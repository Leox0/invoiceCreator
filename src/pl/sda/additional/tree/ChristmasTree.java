package pl.sda.additional.tree;

import pl.sda.service.ConsoleDisplayService;

public class ChristmasTree {
    static ConsoleDisplayService display = new ConsoleDisplayService();
    public static void main(String[] args) {
        Tree tree = new Tree();
       // display.display2DArray(christmasTree.ground(4));
        //tree.tree(3);
        display.display2DArray(tree.createTreeSector(3));

    }
    private char[][] ground(int x){
        return display.createInvoiceTemplate(2,x);
    }



}
