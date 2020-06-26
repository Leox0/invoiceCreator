package pl.sda.additional;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SpeedWriting {

    public static void main(String[] args) throws InterruptedException {
        int numberOfTries = 3;
        String[] sentence = generateSentences();
        Scanner scanner = new Scanner(System.in);
        double[] timeElapsed = new double[numberOfTries];
        double[] accuracyTable = new double[numberOfTries];

        for (int i = 0; i < numberOfTries; i++) {
            System.out.print("odliczanie ");
            for (int j = 3; j > 0; j--) {
                System.out.print(j + "... ");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println();
            String randomSentence = getRandomSentence(sentence);
            System.out.println(randomSentence);
            long startTime = System.nanoTime();
            String input = scanner.nextLine();
            System.out.println();
            long endTime = System.nanoTime();
            timeElapsed[i] = (endTime - startTime) / 1000000000.0;
            accuracyTable[i] = calculateAccuracy(randomSentence, input);
        }
        double avgTime = 0;
        double avgAccuracy = 0;
        for (int i = 0; i < numberOfTries; i++) {
            avgAccuracy += accuracyTable[i];
            avgTime += timeElapsed[i];
        }
        System.out.println("Avg. acuracy = " + avgAccuracy / numberOfTries + "%");
        System.out.println("Avg. time = " + avgTime / numberOfTries + "s");
    }

    private static double calculateAccuracy(String randomSentence, String input) {
        int mistakesCounter;
        /**
         * krojenie zdań na słowa
         */
        String[] randomSentenceWords = randomSentence.split(" ");
        String[] inputWords = input.split(" ");

        /**
         * każde słowo zamało lub za dużo lizone jest jako błąd
         */
        mistakesCounter = Math.abs(randomSentenceWords.length - inputWords.length);

        /**
         * liczymy jako błąd każde słowo które wpisał użytkownik i nie występuje ono w wyświetloną
         */
        for (String word : inputWords) {
            if (!randomSentence.contains(word)) {
                mistakesCounter++;
            }
        }
        double percentageAccuracy = 100.0 * (randomSentenceWords.length - mistakesCounter) / randomSentenceWords.length;
        return percentageAccuracy < 0 ? 0 : percentageAccuracy;
    }

    private static String getRandomSentence(String[] sentence) {
        return sentence[new Random().nextInt(sentence.length)];
    }

    private static String[] generateSentences() {
        return new String[]{
                "Siała baba mak nie wiedziała jak",
                "Wlazł kotek na płotek i mruga",
                "gdyby kózka nie skakła, to by nóżki nie załamała",
                "Na zielonej łące 1 2 3, pasły się zające 1 2 3",
                "jedzie pocziąg z daleka, na nikogo nie czeka",
                "Na lewo na prawo w górę i w dół",
                "Hej, hej, hej sokoły, omijajcie góry, lasy, pola, doły",
                "Entliczek pętliczek czerwny stoliczek",
                "Król Karol kupił królowej Karolinie korale koloru koraloweg",
                "W Szczebrzeszynie chrząszcz brzmi w trzcinie"
        };
    }
}
