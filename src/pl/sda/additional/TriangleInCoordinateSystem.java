package pl.sda.additional;

public class TriangleInCoordinateSystem {
    public static void main(String[] args) {

        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        double ab = a.calculateDistance(b);
        double bc = b.calculateDistance(c);
        double ca = c.calculateDistance(a);
        System.out.println("pole wynosi: " + heronsFormula(ab, bc, ca));
    }

    private static double heronsFormula(double ab, double bc, double ca) {
        double p = (ab + bc + ca) / 2.0;
        return Math.round(Math.sqrt(p * (p - ab) * (p - bc) * (p - ca)));
    }

    private static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double calculateDistance(Point point) {
            return Math.sqrt(
                    (point.x - this.x) * (point.x - this.x) +
                            (point.y - this.y) * (point.y - this.y)
            );
        }
    }
}

