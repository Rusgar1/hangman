package main.java.com.myproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RandomWordReader {
    public String readRandomWord() {
        String filePath = "src/main/java/resources/dictionary.txt";
        String randomWord = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String firstLine = reader.readLine();
            int randomNum = (int) (Math.random() * Integer.parseInt(firstLine)) + 1;
            int currentLine = 2;
            while ((randomWord = reader.readLine()) != null) {
                if (currentLine == randomNum) {
                    break;
                }
                currentLine++;
            }

            if (randomWord != null) {
                randomWord = randomWord.toUpperCase();
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return randomWord;
    }
}
