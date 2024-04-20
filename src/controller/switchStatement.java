package controller;

import java.util.Scanner;

public class switchStatement {
    public static void main(String[] args) {

        String snack;
        Scanner input = new Scanner(System.in);
        System.out.println("kies een snack, appel of chocolade: ");

        snack = input.next();
        switch (snack){
            case "appel" -> System.out.println("lekker fruit");
            case "chocolage" -> System.out.println("lekker chocolade");
            default -> System.out.println("foutieve input: kies appel of chocolade");
        }
    }
}
