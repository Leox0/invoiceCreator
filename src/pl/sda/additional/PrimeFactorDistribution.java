package pl.sda.additional;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorDistribution {
    public static void main(String[] args) {
        System.out.println(primeFactorDistribution(5070));
    }

    private static List<Integer> primeFactorDistribution(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
