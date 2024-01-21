package org.example.task2;

public class Ex20 {
    public static void main(String[] args){
        Vector[] vectors = Vector.generate(10);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].lenghtVector());
        System.out.println(vectors[0].scalarProduct(vectors[1]));
        System.out.println(vectors[0].vectorProduct(vectors[1]));
        System.out.println(vectors[0].cosAngle(vectors[1]));
        System.out.println(vectors[0].add(vectors[1]));
        System.out.println(vectors[0].difference(vectors[1]));

    }
    public static class Vector{
        private double x;
        private double y;
        private double z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public double lenghtVector(){
            return Math.sqrt((x*x+y*y+z*z));
        }
        public double scalarProduct(Vector vector){
            return x * vector.x + y * vector.y + z * vector.z;
        }
        public Vector vectorProduct(Vector vector){
            return new Vector(
                    y * vector.z - z * vector.y,
                    z * vector.x - x * vector.z,
                    x * vector.y - y * vector.x);
        }
        public double cosAngle(Vector vector){
            return scalarProduct(vector) / (lenghtVector() * vector.lenghtVector());
        }
        public Vector add(Vector vector) {
            return new Vector(
                    x + vector.x,
                    y + vector.y,
                    z + vector.z
            );
        }

        public Vector difference(Vector vector) {
            return new Vector(
                    x - vector.x,
                    y - vector.y,
                    z - vector.z
            );
        }
        public static Vector[] generate(int n){
            Vector[] vectors = new Vector[n];
            for(int i =0; i < n; i++){
                vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
            }
            return vectors;
        }
    }
}
