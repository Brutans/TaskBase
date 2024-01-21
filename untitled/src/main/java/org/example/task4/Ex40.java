package org.example.task4;
import java.util.ArrayList;

public class Ex40 {
    static class Shape {
    private double volume;

    public Shape(double volume){
        this.volume = volume;
    }
    public double getVolume(){
        return volume;
        }
    }
    static class SolidOfRevolution extends Shape{
        private double radius;

        public SolidOfRevolution(double volume,double radius){
            super (volume);
            this.radius = radius;
        }
        public double getRadius(){
            return radius;
        }
    }
    static class Pyramid extends Shape{
        private double s;
        private double h;

        public Pyramid(double s, double h) {
            super(13*s*h);
            this.s = s;
            this.h = h;
        }
    }
    static class Cylinder extends SolidOfRevolution {
        private double height;

        public Cylinder(double radius, double height) {
            super(Math.PI * radius * radius * height, radius);
            this.height = height;

        }
    }

    static class Ball extends SolidOfRevolution{

        public Ball( double radius) {
            super(4/3 * Math.PI * radius*radius*radius, radius);
        }
    }

    static class Box extends Shape{
        private ArrayList<Shape> shapes = new ArrayList<>();
        private double available;

        public Box(double available) {
            super(available);
            this.available = available;
        }

        public boolean add(Shape shape) {
            if (available >= shape.getVolume()) {
                shapes.add(shape);
                available -= shape.getVolume();
                return true;
            } else {
                return false;
            }
        }

    }


    public static void main(String[] args){
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);

        Box box = new Box(1000);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(pyramid));

    }

}
