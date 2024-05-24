package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пример: ");

        String allExpression = scanner.nextLine();
        String [] currentNums = allExpression.split(" ");

        if (isDigit(currentNums[0]) && isDigit(currentNums[2])) {
            switch (currentNums[1]) {
                case "+":
                    System.out.println(Integer.parseInt(currentNums[0]) + Integer.parseInt(currentNums[2]));
                    break;
                case "-":
                    System.out.println(Integer.parseInt(currentNums[0]) - Integer.parseInt(currentNums[2]));
                    break;
                case "*":
                    System.out.println(Integer.parseInt(currentNums[0]) * Integer.parseInt(currentNums[2]));
                    break;
                case "/":
                    System.out.println(Integer.parseInt(currentNums[0]) / Integer.parseInt(currentNums[2]));
                    break;
                default:
                    throw new IOException();
            }
        } else if (Roman.isRoman(currentNums[0]) && Roman.isRoman(currentNums[2])) {

            int num1 = Roman.getArrabNum(currentNums[0]);
            int num2 = Roman.getArrabNum(currentNums[2]);

            if (num1 > 10 || num2 > 10) {
                throw new IOException();
            }

            switch (currentNums[1]) {
                case "+":
                    String resultPlus = Roman.getRomNumFromArrab(num1 + num2);
                    System.out.println(resultPlus);
                    break;
                case "-":
                    if ((num1 - num2) > 0) {
                        String resultMinus = Roman.getRomNumFromArrab(num1 - num2);
                        System.out.println(resultMinus);
                        break;
                    } else {
                        throw new IOException();
                    }
                case "*":
                    String resultMultiply = Roman.getRomNumFromArrab(num1 * num2);
                    System.out.println(resultMultiply);
                    break;
                case "/":
                    String resultDivide = Roman.getRomNumFromArrab(num1 / num2);
                    System.out.println(resultDivide);
                    break;
                default:
                    throw new IOException();
            }
        } else {
            throw new IOException();
        }
    }

    public static boolean isDigit(String s){
        String[] arabNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < arabNums.length; i++) {
            if (s.equals(arabNums[i])) {
                return true;
            }
        }
        return false;
    }
}