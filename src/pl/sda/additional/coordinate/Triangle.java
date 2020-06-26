package pl.sda.additional.coordinate;

import java.awt.*;
import java.awt.geom.Point2D;

public class Triangle {

    public Point2D p1 = new Point2D() {
        @Override
        public double getX() {
            return 0;
        }

        @Override
        public double getY() {
            return 0;
        }

        @Override
        public void setLocation(double x, double y) {

        }
    };
    public Point p2;
    public Point p3;


}
