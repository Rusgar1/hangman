package main.java.com.myproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        Scanner in = new Scanner(System.in);
        String input;
        do {
            System.out.println("1 - начать новую игру, 0 - выйти из приложения");
            input  = in.nextLine();
            if (input.equals("1")) {
                System.out.printf("Your number: %s \n", input);
                hangmanGame.newRound();
            } else if (input.equals("0")) {
                System.out.printf("Your number: %s \n", input);
                return;
            } else {
                System.out.println("Ошибка: число должно быть 0 или 1");
            }
        } while (true) ;
    }
}
