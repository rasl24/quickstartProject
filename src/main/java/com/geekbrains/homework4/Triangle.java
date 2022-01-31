package com.geekbrains.homework4;

public class Triangle {
    public static double calculatingAreaTriangle(double a, double b, double c) throws Exception {
        if(a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Значение одной из сторон является отрицательным или 0!!!");
            throw new Exception();
        }
        double p = (a + b + c) / 2;
        if (p == a || p == b || p == c){
            System.out.println("Это вырожденный треугольник!!!");
            throw new Exception();
        }
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника: " + square);
        return square;
    }
}
