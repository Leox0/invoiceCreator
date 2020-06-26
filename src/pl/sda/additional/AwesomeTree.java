package pl.sda.additional;

public class AwesomeTree {

    public static void main(String[] args) {
        awesomeTree(10);
    }

    public static void awesomeTree(int segments) {
        /**
         * tworzenie odpowieniej liczby segmentów. w celu uniknięcia 'rozjechania się' segmentów
         * istotnym jest aby zwiększać wsunięcie segmentu (offset) odwrotnie proporcjonalnie do jego wielkości
         */
        for (int i = 0; i < segments; i++) {
            displayTreeSegment(i +3, segments - i);
        }
        displayLog(segments);
    }

    /**
     * wyświetlanie pnia
     */
    private static void displayLog(int segments) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < segments * 2 + 3; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void displayTreeSegment(int dimension, int offset) {
        String space = " ";
        String star = "*";

        for (int i = 0; i < dimension; i++) {
            /**
             * wykonanie przesunięcia w celu iniknięcia rozjechania
             */
            for (int j = 0; j < offset; j++) {
                System.out.print(space + space);
            }
            /**
             * spacje w celu utworzenia trójkątów z gwiazdek
             */
            for (int j = 1; j < dimension - i; j++) {
                System.out.print(space + space);
            }

            /**
             * Transformacja trójkąta prostokątnego na równoramienny (wykomentuj i zobacz co sie stanie)
             *      *                   *
             *      * *      --->      * *
             *      * * *             * * *
             */
            for (int j = 0; j < i; j++) {
                System.out.print(space);
            }

            /**
             * drukowanie gwiazdek
             */
            for (int j = 0; j < i + 1; j++) {
                System.out.print(star + space);
            }
            System.out.println();
        }
    }
}
