package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int i = 10;
        Scanner scanner = new Scanner(System.in);
        while(i > 0){
            System.out.print("Ввод с консоли ");
            String numberString = scanner.next();
            Numbers number = new Numbers(new Rubles());
            String numberWordString = number.getNumberWordSring(numberString);
            System.out.print("Вывод программы: " + numberWordString + "\n");
        }


        System.out.println("Hello world!");
    }
}