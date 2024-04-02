package main.java.com.myproject;

import java.util.Scanner;

public class StartGame {
    public static void startGame() {
        try(Scanner in = new Scanner(System.in)){
            int num = -1;
            while (num !=0 && num !=1) {
                System.out.println("1 - начать новую игру, 0 - выйти из приложения");
                num = in.nextInt();
                if (num == 1) {
                    System.out.printf("Your number: %d \n", num);

                    RandomWordReader randomWordReader = new RandomWordReader();
                    String randomWord = randomWordReader.readRandomWord();

                    HangmanGame hangmanGame = new HangmanGame();
                    hangmanGame.createStarWord(hangmanGame.getHiddenWord(randomWord));


                } else if (num == 0) {
                    System.out.printf("Your number: %d \n", num);
                }else {
                    System.out.println("Ошибка: число должно быть 0 или 1");
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
