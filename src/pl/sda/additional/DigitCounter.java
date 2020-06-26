package pl.sda.additional;

public class DigitCounter {

    public static void main(String[] args) {
        System.out.println(countDigits(16523761523123L));
    }

    private static int countDigits(Long number) {
        return String.valueOf(number).length();
    }
}
