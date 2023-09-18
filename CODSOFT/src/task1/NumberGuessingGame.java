package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minmiumRange = 1;
        int maximumRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + minmiumRange + " and " + maximumRange + ". Try to guess it.");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maximumRange - minmiumRange + 1) + minmiumRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt #" + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess < minmiumRange || userGuess > maximumRange) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attempts++;
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Game Over! Your score: " + score);
        scanner.close();
    }
}

