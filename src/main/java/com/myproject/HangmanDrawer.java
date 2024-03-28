package main.java.com.myproject;


public class HangmanDrawer {
    //Этот класс будет отвечать за отображение текущего состояния игры,
    // включая построение виселицы и вывод на экран текущего статуса игры.

    // Метод для отображения виселицы в зависимости от количества ошибок
    public void drawHangman(int errors) {
        switch (errors) {
            case 0:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("__|__");
                break;
            case 1:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("__|__");
                break;
            case 2:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println("__|__");
                break;
            case 3:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|");
                System.out.println(" |");
                System.out.println("__|__");
                break;
            case 4:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |");
                System.out.println("__|__");
                break;
            case 5:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |   /");
                System.out.println("__|__");
                break;
            case 6:
                System.out.println("  _____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |   / \\");
                System.out.println("__|__");
                System.out.println("Игра завершена.");
                break;
            default:
                System.out.println("Неправильное количество ошибок!");
                break;
        }
    }

    // Метод для отображения текущего статуса игры
    public void displayGameStatus(char[] wordStatus, int errors, String incorrectLetters) {
        System.out.println("Текущее состояние слова: " + new String(wordStatus));
        drawHangman(errors);
        System.out.println("Неправильные буквы: " + incorrectLetters);
    }
}
