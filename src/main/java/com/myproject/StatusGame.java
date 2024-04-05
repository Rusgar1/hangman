package main.java.com.myproject;


import java.util.ArrayList;
import java.util.Set;

public class StatusGame {
//Этот класс будет отвечать за отображение текущего состояния игры,
    // включая построение виселицы и вывод на экран текущего статуса игры.

    // Метод для отображения виселицы в зависимости от количества ошибок
    public void statusGame(int errors) {
        switch (errors) {
            case 0:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 1:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 2:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 3:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 4:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 5:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |   /");
                System.out.println("__|__");
                break;
            case 6:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |   / \\");
                System.out.println("__|__");
                System.out.println("Игра завершена.");
                break;
        }
    }

    // Метод для отображения текущего статуса игры

    public void displayGameStatus(ArrayList<Character> starWord) {
        System.out.println("Слово: " + collectionToString(starWord));
    }

    public void displayGameStatus(String warning, ArrayList<Character> starWord, int errors, char guess) {
        statusGame(errors);
        System.out.println(guess + " - " + warning);
        System.out.println("Слово: " + collectionToString(starWord));
        System.out.println("Ошибок: " + errors);
    }

    public void displayGameStatus(String guessed, ArrayList<Character> starWord, int errors, Set<Character> incorrectCharacters, char guess) {
        statusGame(errors);
        System.out.println(guess + " - " + guessed);
        System.out.println("Слово: " + collectionToString(starWord));
        System.out.println("Ошибок: " + errors + ": " + collectionToString(incorrectCharacters));
    }

    public void displayGameStatus(ArrayList<Character> starWord, int errors, Set<Character> incorrectCharacters, char guess) {
        statusGame(errors);
        System.out.println(guess);
        System.out.println("Слово: " + collectionToString(starWord));
        System.out.println("Ошибок: " + errors + ": " + collectionToString(incorrectCharacters));
    }

    public void displayGameStatus(String gameOver, ArrayList<Character> hiddenWord, ArrayList<Character> starWord, int errors, Set<Character> incorrectCharacters) {
        statusGame(errors);
        System.out.println(gameOver);
        System.out.println("Слово: " + collectionToString(starWord));
        System.out.println("Ошибок: " + errors + ":" + collectionToString(incorrectCharacters));
        System.out.println("Загаданное слово: " + collectionToString(hiddenWord));
    }


    public String collectionToString(Iterable<Character> collection) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (char c : collection) {
            if (!first) {
                sb.append(" ");
            } else {
                first = false;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
