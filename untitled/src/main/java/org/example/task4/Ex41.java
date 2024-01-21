package org.example.task4;


import java.util.ArrayList;

public class Ex41 {
    static abstract class Shape {
        private double volume;

        public Shape(double volume){
            this.volume = volume;
        }
        public double getVolume(){
            return volume;
        }
    }
    static class SolidOfRevolution extends Ex40.Shape {
        private double radius;

        public SolidOfRevolution(double volume,double radius){
            super (volume);
            this.radius = radius;
        }
        public double getRadius(){
            return radius;
        }
    }
    static class Pyramid extends Ex40.Shape {
        private double s;
        private double h;

        public Pyramid(double s, double h) {
            super(13*s*h);
            this.s = s;
            this.h = h;
        }
    }
    static class Cylinder extends Ex40.SolidOfRevolution {
        private double height;

        public Cylinder(double radius, double height) {
            super(Math.PI * radius * radius * height, radius);
            this.height = height;

        }
    }

    static class Ball extends Ex40.SolidOfRevolution {

        public Ball( double radius) {
            super(4/3 * Math.PI * radius*radius*radius, radius);
        }
    }

    static class Box extends Ex40.Shape {
        private ArrayList<Ex40.Shape> shapes = new ArrayList<>();
        private double available;

        public Box(double available) {
            super(available);
            this.available = available;
        }

        public boolean add(Ex40.Shape shape) {
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
        Ex40.Ball ball = new Ex40.Ball(4.5);
        Ex40.Cylinder cylinder = new Ex40.Cylinder(2, 2);
        Ex40.Pyramid pyramid = new Ex40.Pyramid(10, 5);//650

        Ex40.Box box = new Ex40.Box(1000);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(pyramid));

    }
}
