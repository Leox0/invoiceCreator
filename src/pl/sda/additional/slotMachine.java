package pl.sda.additional;

import java.util.Random;
import java.util.Scanner;

public class slotMachine {
    private static int WALLET = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w kasynie, stan twojego portfela wynosi: " + WALLET);
        System.out.println("Zaczynamy zabawę!");
        while (WALLET > 0) {
            System.out.println("Jaką kwotę wrzucasz? (5,10,20," + WALLET + ")");
            int money = scanner.nextInt();
            if (money == 5 || money == 10 || money == 20 || money == WALLET) {
                play(money);
                System.out.println("Twój obecny stan ktonta wynosi: " + WALLET);
                System.out.println("Gramy dalej? (Y/N)");
                String shouldContinue = scanner.next();
                if (shouldContinue.equals("N")) {
                    break;
                }

            } else {
                System.out.println("nie możesz grać o taką stawkę");
            }
        }
        if (WALLET == 0) {
            System.out.println("Przegrałeś wszystko, nie masz już pieniędzy żeby kontynuować grę...");
        } else {
            System.out.println("Zakończyłes grę z " + WALLET + " PLN w portfelu");
        }

    }

    private static void play(int money) {
        Random random = new Random();
        boolean b = random.nextBoolean();
        if (b) {
            WALLET += money;
            System.out.println("Gratulacje, udało ci się wygrać " + money * 2);
        } else {
            WALLET -= money;
            System.out.println("Spróbuj szczęscia innym razem");
        }
    }
}
