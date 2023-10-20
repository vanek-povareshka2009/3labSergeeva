package org.example;

public class MySimpleException extends RuntimeException{

    public MySimpleException(int i, int j, String value){
        super("В матрице в строке [" + (i+1) + "] в столбце ["+ (j+1) +"] находится простое число от 1 до 500: " + value);
    }
}
