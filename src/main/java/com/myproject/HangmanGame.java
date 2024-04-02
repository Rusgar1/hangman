package main.java.com.myproject;

import java.util.*;

public class HangmanGame {
    //Этот класс будет отвечать за логику игры, включая управление словом,
    // отгаданными буквами и проверку предложенных букв пользователем.

    private String warning = "используй буквы русского алфавита";
    private String guessedLetter = "Ввел отгаданную букву";
    private String gameOver = "GAME OVER";
    private int errorCount = 0; //счетчик ошибок
    private int uniqueCharInWord = 0; //кол-во уникальных букв в слове
    private int counQuessedCharInWord = 0; // кол-во отгаданных символов в слове
    private boolean correctGuess; // флаг для отслеживания угаданной буквы

    private char star = '*'; // звездочка

    ArrayList<Character> hiddenWord = new ArrayList<>(); // загаданное слово wordCharacters
    ArrayList<Character> starWord = new ArrayList<>(); // массив слова из звезд ****

    Set<Character> incorrectCharacters = new HashSet<>(); // Создаем Set для хранения символов не входяящих в загаданное слово sb
    StatusGame statusGame = new StatusGame();

    public ArrayList<Character> getHiddenWord(String randomWord) {
        for (int i = 0; i < randomWord.length(); i++) {
            char c = randomWord.charAt(i);
            hiddenWord.add(c);
        }
        return hiddenWord;
    }

    public void createStarWord(ArrayList<Character> hiddenWord) {
        for (int i = 0; i < hiddenWord.size(); i++) {
            starWord.add(star);
        }
        suggestLetter();
    }

    public void suggestLetter() {
        try (Scanner in = new Scanner(System.in)) {
            while (errorCount !=6 && counQuessedCharInWord != hiddenWord.size()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Введи букву, которая может входить в загаданное слово");
                char guess = Character.toUpperCase(in.next().charAt(0));
                if (!isValidChar(guess)) {
                    statusGame.displayGameStatus(warning, starWord, errorCount, guess);
                } else if (incorrectCharacters.contains(guess)){
                    statusGame.displayGameStatus(guessedLetter, starWord, errorCount, incorrectCharacters, guess);
                } else {
                    suggestLetter1(guess);
                }
            }
        }
    }

    public boolean isValidChar(char guess) {
        boolean correctChar = Character.isLetter(guess) && Character.UnicodeBlock.of(guess) == Character.UnicodeBlock.CYRILLIC;
        return correctChar;
    }

    public void suggestLetter1(char guess){
        correctGuess = false; // Сбрасываем флаг перед каждой попыткой угадывания

        for (int i = 0; i < hiddenWord.size(); i++) {
            if(hiddenWord.get(i) == guess){
                starWord.set(i, guess);
                correctGuess = true;
                uniqueCharInWord++;
                counQuessedCharInWord++;
                if (counQuessedCharInWord == starWord.size()){
                    break;
                } else if (uniqueCharInWord == 1) {
                    statusGame.displayGameStatus(starWord,errorCount, incorrectCharacters, guess);
                }
            }
        }

        if (uniqueCharInWord >1){
            statusGame.displayGameStatus(starWord,errorCount, incorrectCharacters, guess);
            uniqueCharInWord = 0;
        }



        if (!correctGuess && errorCount !=5) {
            errorCount++;
            incorrectCharacters.add(guess);
            incorrectCharacters.add(' ');
            statusGame.displayGameStatus(starWord, errorCount, incorrectCharacters, guess);
        } else if (!correctGuess && errorCount == 5) { // это лишняя операция?
            errorCount++;
            incorrectCharacters.remove(guess);
            incorrectCharacters.add(' ');
        }

        if(errorCount == 6 || counQuessedCharInWord == hiddenWord.size()){
            statusGame.displayGameStatus(gameOver, hiddenWord, starWord, errorCount, incorrectCharacters);
            hiddenWord.clear();
            starWord.clear();
            incorrectCharacters.clear();
            errorCount = 0;
            counQuessedCharInWord = 0;
            StartGame.startGame();
        }
    }
}


