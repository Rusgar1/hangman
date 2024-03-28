package main.java.com.myproject;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// доработать: проверку введенного символа из списка ранее введенных букв
// также System.out.println("Ошибки: " + (errorCount)); должен показывать все введенные ошибочные буквы

public class HangmanGame {
    //Этот класс будет отвечать за логику игры, включая управление словом,
    // отгаданными буквами и проверку предложенных букв пользователем.

    private int attemptsCount; // переменная для хранения количества попыток
    private char[] wordCharacters; // массив символов слов
    private char[] starArray; // массив спрятанного слова
    private int errorCount = 0; //счетчик ошибок
    private boolean correctGuess; // флаг для отслеживания правильности угаданной буквы
    StringBuilder sb = new StringBuilder();

    public char[] getWordCharacters(String randomWord) {
        wordCharacters = randomWord.toCharArray();
        return wordCharacters;
    }

    public void createStarArray(char[] wordCharacters) {
        starArray = new char[wordCharacters.length];
        Arrays.fill(starArray, '*');
        suggestLetter();
    }

    public void suggestLetter() {
        HangmanDrawer drawer = new HangmanDrawer();
        try (Scanner in = new Scanner(System.in)) {
            while (attemptsCount < wordCharacters.length) {
                System.out.println("Введи букву, которая может входить в загаданное слово");
                char guess = Character.toUpperCase(in.next().charAt(0));

                correctGuess = false; // Сбрасываем флаг перед каждой попыткой угадывания

                for (int i = 0; i < wordCharacters.length; i++) {
                    if (!Character.isLetter(guess) || Character.UnicodeBlock.of(guess) != Character.UnicodeBlock.CYRILLIC) {
                        System.out.println("Используй буквы из русского алфавита");
                        break;
                    }

                    if(starArray[i] == guess){ break; }

                    if (wordCharacters[i] == guess) {
                        starArray[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    errorCount++;
                    sb.append(guess);
                    sb.append(" ");
                    drawer.drawHangman(errorCount);
                }

                attemptsCount++;

                System.out.println("Слово: " + Arrays.toString(starArray));
                System.out.println("Ошибок: " + (errorCount) + ": " + sb);
                System.out.println("Буква: " + guess);
                System.out.println("Загаданное слово: " + Arrays.toString(wordCharacters));
            }
//            if(attemptsCount == wordCharacters.length){}
        }
    }
}
