package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int rectangleCount = 0;
        int size = a.length;
        byte[][] b = new byte[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (a[i][j] == 1 && b[i][j] == 0) {
                    rectangleCount++;

                    for (int k = i; k < size; k++) {
                        for (int l = j; l < size; l++) {
                            if (a[k][l] == 0) break;
                            b[k][l] = 1;
                        }
                        if (a[k][j] == 0) break;
                    }
                }
            }
        }
        return rectangleCount;
    }
}
