package main.java.com.myproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame hangmanGame = new HangmanGame();
        String input;
        do {
            System.out.println("1 - начать новую игру, 0 - выйти из приложения");
            if(scanner.hasNextLine()){
                input  = scanner.nextLine();
                if (input.equals("1")) {
                    System.out.printf("Your number: %s \n", input);
                    hangmanGame.newRound();
                } else if (input.equals("0")) {
                    System.out.printf("Your number: %s \n", input);
                    return;
                } else {
                    System.out.println("Ошибка: число должно быть 0 или 1");
                }
            }
        } while (true) ;
    }
}
