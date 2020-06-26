package pl.sda.additional.bandit;

public class OneArmedBandit {
    /*    4) stworz program symulujący jednorękiego bandytę. stwórz metodę play() która przyjmie jako parametr ilość pieniedzy wrzuconą przez użytkownika.
        Uzytkownik po właczeniu programu posiada 100zł w portfelu i może wrzucić do maszyny 5,10,20 lub wszystko. Maszyna w sposób pseudolosowy (Math.random()) decyduje o tym czy użytkoniwk wygrał czy przegrał.
        Jeżeli przegrał to traci wrzucone pieniądze, jeżeli wygrał podwaja wrzuconą kwotę i dodaje do portfela użytkownika.
        jeżeli użytkownikowi skończą się pieniądze, to wyświetl komunikat że przegrał i zamknij program.
        https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java*/

    private int pocket;

    public OneArmedBandit() {
        this.pocket = 100;
    }

    public int getPocket() {
        return pocket;
    }

    public void play(int money) {
        if (pocket >= money) {
            if (Math.round(Math.random()) == 1) {
                System.out.println("Wygrałeś!");
                pocket += 2 * money;
            } else {
                System.out.println("Przegrałeś!");
                pocket -= money;
            }
        } else {
            System.out.println("Nie stać Cię!");
        }
    }


}
