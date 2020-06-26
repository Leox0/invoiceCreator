package pl.sda.service;

import pl.sda.model.AccountNumber;
import pl.sda.model.Nip;
import pl.sda.model.PostalCode;

public class Tmp {


    /*    1) stwórz metodę statyczną validatePostalCode() w klasie Address, która wykorzystując wyrażenia regularne zapewni poprawność wprowadzonego kodu pocztowego.
        Jeżeli użytkownik wprowadzi niepoprawny kod pocztowy, poproś o niego ponownie.
        - interesuje nas pattern XX-XXX*/
    public static boolean validatePostalCode(PostalCode postalCode) {
        String code = postalCode.getValue();
        String regex = "[0-9]{2}-[0-9]{3}";
        return code.matches(regex);
    }

    /*
        2) stwórz metodę statyczną validateNip() w klasie Entity, która wykorzystując wyrażenia regularne zapewni poprawność wprowadzonego nipu.
        Jeżeli użytkownik wprowadzi niepoprawny nip, poproś o niego ponownie.
        interesuje nas:
        - dlugosc
        - fakt ze sa to same cyfry
        - suma kontrolna numeru nip ( nie sprawdzamy czy numer urzedu jest prawidłowy)
    */
    public static boolean validateNip(Nip nip) {
        String code = nip.getValue();
        boolean result;
        String regex = "\\d{10}";
        if (!code.matches(regex)) {
            result = false;
        } else {
            if (validateControlSum(code)) {
                result = true;
            } else
                result = false;
        }

        return result;
    }

    private static boolean validateControlSum(String code) {

        int sum = 6 * Character.getNumericValue(code.charAt(0))
                + 5 * Character.getNumericValue(code.charAt(1))
                + 7 * Character.getNumericValue(code.charAt(2))
                + 2 * Character.getNumericValue(code.charAt(3))
                + 3 * Character.getNumericValue(code.charAt(4))
                + 4 * Character.getNumericValue(code.charAt(5))
                + 5 * Character.getNumericValue(code.charAt(6))
                + 6 * Character.getNumericValue(code.charAt(7))
                + 7 * Character.getNumericValue(code.charAt(8));
        sum %= 11;
        return Character.getNumericValue(code.charAt(9)) == sum;

    }

/*    3) stwórz metodę statyczną validateAccountNumber() w klasie Entity, która wykorzystując wyrażenia regularne zapewni poprawność wprowadzonego numeru konta.
    Jeżeli użytkownik wprowadzi niepoprawny numer konta, poproś o niego ponownie.
	- interesuje nas długość*/

    public static boolean validateAccountNumber(AccountNumber accountNumber) {
        String number = accountNumber.getValue();
        String regex = "\\d{26}";
        return number.matches(regex);
    }

/*    Zadania dodatkowe;
1) stwórz metodę countDigits() która przyjmie w parametrze liczbę (Long) i zrwórci ilość cyfr z których składa się ta liczba (int)
*/

    public static int countDigits(Long number) {
        return number.toString().length();
    }

    /*2) stówrz metode primeFactorDistribution() która dla podanel liczby zwróci w postaci tablicy jej rozkład na czynniki pierwsze. np:
                12 -> [2,2,3]
                13 -> [13]
                105 -> [5,3,7]*/
    public static void primeFactorDistribution(int number) {
        //int [] array = new int[];
        int x = number, i, e;
        i = 2;
        e = (int) (Math.sqrt(x));
        while (i <= e) {
            while ((x % i) == 0) {
                x /= i;
                e = (int) (Math.sqrt(x));
                System.out.print(" " + i);
            }
            i++;
        }
        if (x > 1) System.out.print(" " + x);
        //return array;

    }

}
// jak zabezpieczyć taką fakturę przed np złymi wymiarami. Żeby ktoś nie wpisał templatki na 2 innch współrzędnych na < template.lenght