package main.java.com.myproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int num = -1;
            while (num !=0 && num !=1) {
                System.out.println("1 - начать новую игру, 0 - выйти из приложения");
                num = in.nextInt();
                if (num == 1) {
                    System.out.printf("Your number: %d \n", num);

                    RandomWordReader randomWordReader = new RandomWordReader();
                    String randomWord = randomWordReader.read_random_word();

                    HangmanGame hangmanGame = new HangmanGame();
                    hangmanGame.createStarArray(hangmanGame.getWordCharacters(randomWord));


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
