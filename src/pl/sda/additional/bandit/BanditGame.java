package pl.sda.additional.bandit;

import java.util.Scanner;

public class BanditGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        OneArmedBandit omgBandit = new OneArmedBandit();
        while (omgBandit.getPocket()>=5) {
            System.out.println("Zostało Ci:" + omgBandit.getPocket() + "zł");
            System.out.println("Ile chcesz wrzucic?");
            System.out.println("A - 5");
            System.out.println("B - 10");
            System.out.println("C - 20");
            System.out.println("D - Wszystko");
            System.out.println("EXIT - Wyjdz z gry");
            String choice = s.nextLine();

            switch (choice) {
                case "A":
                case "a":
                    omgBandit.play(5);
                    break;
                case "B":
                case "b":
                    omgBandit.play(10);
                    break;
                case "C":
                case "c":
                    omgBandit.play(20);
                    break;
                case "D":
                case "d":
                    omgBandit.play(omgBandit.getPocket());
                    break;
                case "exit":
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowa opcja");
            }


        }
    }
}
