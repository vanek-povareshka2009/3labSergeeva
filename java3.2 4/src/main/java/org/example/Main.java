package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"13", "90", "114.0", "36"},
                {"123", "100", "90", "150"},
                {"15", "49", "160", "117"},
                {"183", "144", "56", "76a"}
        };

        try {
            System.out.println("Сумма чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MySimpleException e){
                e.printStackTrace();
        }
    }
    public static double method(String[][] array) throws MyArraySizeException, MyArrayDataException, MySimpleException {

        if(array.length != 4){
            throw new MyArraySizeException("Размер матрицы не 4x4!");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException("Размер матрицы не 4x4!");
            }
        }
        double number;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    if(array[i][j].contains(",")){
                        array[i][j] = array[i][j].replace(',','.');
                    }
                    number = Double.parseDouble(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                try {
                    if(array[i][j].contains(",")){
                        array[i][j] = array[i][j].replace(',','.');
                    }
                    number = Double.parseDouble(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }


            }

        }

        return sum;
    }
    public static boolean mySimple(double number) {
        if (number <= 1) {
            return false; // 1 и меньшие числа не являются простыми
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // число делится нацело, не является простым
            }
        }
        return true; // число простое
    }


}