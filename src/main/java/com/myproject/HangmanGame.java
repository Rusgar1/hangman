package main.java.com.myproject;

import java.util.*;

public class HangmanGame {
    //Этот класс будет отвечать за логику игры, включая управление словом,
    // отгаданными буквами и проверку предложенных букв пользователем.

    private String warning = "используй буквы русского алфавита";
    private String guessedLetter = "Ввел отгаданную букву";
    private String guessedIncorrectCharacters = "Повторно ввел символ, отсутствующий в скретном слове";
    private String gameOver = "GAME OVER";
    private int errorCount; //счетчик ошибок
    private int uniqueCharInWord; //кол-во уникальных букв в слове
    private int counQuessedCharInWord; // кол-во отгаданных символов в слове
    private boolean correctGuess; // флаг для отслеживания угаданной буквы

    private char star = '*'; // звездочка

    ArrayList<Character> hiddenWord = new ArrayList<>(); // загаданное слово wordCharacters
    ArrayList<Character> starWord = new ArrayList<>(); // массив слова из звезд ****

    Set<Character> incorrectCharacters = new HashSet<>(); // Создаем Set для хранения символов не входяящих в загаданное слово sb
    StatusGame statusGame = new StatusGame();


    public void newRound() {
        RandomWordReader randomWordReader = new RandomWordReader();
        String randomWord = randomWordReader.readRandomWord();
        hiddenWord = getHiddenWord(randomWord);
        createStarWord(hiddenWord);
        suggestLetter();
    }


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

    }

    public void suggestLetter() {
        try (Scanner in = new Scanner(System.in)) {
            while (errorCount != 6 && counQuessedCharInWord != hiddenWord.size()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Введи букву, которая может входить в загаданное слово");
                statusGame.displayGameStatus(starWord);
                char guess = Character.toUpperCase(in.next().charAt(0));
                if (!isValidChar(guess)) {
                    statusGame.displayGameStatus(warning, starWord, errorCount, guess);
                } else if (incorrectCharacters.contains(guess)) {
                    statusGame.displayGameStatus(guessedIncorrectCharacters, starWord, errorCount, incorrectCharacters, guess);
                } else if (starWord.contains(guess)) {
                    statusGame.displayGameStatus(guessedLetter, starWord, errorCount, incorrectCharacters, guess);
                } else {
                    processGuessedLetter(guess);
                }
            }
        }
    }

    public boolean isValidChar(char guess) {
        return Character.isLetter(guess) && Character.UnicodeBlock.of(guess) == Character.UnicodeBlock.CYRILLIC;
    }

    public void processGuessedLetter(char guess) {
        correctGuess = false; // Сбрасываем флаг перед каждой попыткой угадывания
        uniqueCharInWord = 0;

        for (int i = 0; i < hiddenWord.size(); i++) {
            if (hiddenWord.get(i) == guess) {
                starWord.set(i, guess);
                correctGuess = true;
                uniqueCharInWord++;
                counQuessedCharInWord++;
                if (counQuessedCharInWord == starWord.size()) {
                    break;
                }
            }
        }

        if (uniqueCharInWord == 1 && counQuessedCharInWord != hiddenWord.size()) {
            statusGame.displayGameStatus(starWord, errorCount, incorrectCharacters, guess);
        }

        if (uniqueCharInWord > 1 && counQuessedCharInWord != hiddenWord.size()) {
            statusGame.displayGameStatus(starWord, errorCount, incorrectCharacters, guess);
            uniqueCharInWord = 0;
        }

        if (!correctGuess && errorCount != 5) {
            errorCount++;
            incorrectCharacters.add(guess);
            incorrectCharacters.add(' ');
            statusGame.displayGameStatus(starWord, errorCount, incorrectCharacters, guess);
        } else if (!correctGuess && errorCount == 5) {
            errorCount++;
            incorrectCharacters.add(guess);
            incorrectCharacters.add(' ');
        }

        if (errorCount != 6 && correctGuess && counQuessedCharInWord == hiddenWord.size()) {
            statusGame.displayGameStatus(gameOver, hiddenWord, starWord, errorCount, incorrectCharacters);
            hiddenWord.clear();
            starWord.clear();
            incorrectCharacters.clear();
            errorCount = 0;
            counQuessedCharInWord = 0;
        }

        if (errorCount == 6 || counQuessedCharInWord == hiddenWord.size()) {
            statusGame.displayGameStatus(gameOver, hiddenWord, starWord, errorCount, incorrectCharacters);
            hiddenWord.clear();
            starWord.clear();
            incorrectCharacters.clear();
            errorCount = 0;
            counQuessedCharInWord = 0;
        }
    }
}


