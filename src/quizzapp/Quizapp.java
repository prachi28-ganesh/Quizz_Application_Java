
package quizzapp;

import java.util.Scanner;

public class Quizapp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();

        boolean running = true;

        System.out.println("==================================");
        System.out.println("       WELCOME TO JAVA QUIZ");
        System.out.println("==================================");

        while (running) {

            System.out.println("\n1. Start Quiz");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    quiz.start(sc);

                    System.out.print(
                        "\nDo you want to play again? (yes/no): ");

                    String response = sc.nextLine().trim();

                    if (!response.equalsIgnoreCase("yes")) {
                        running = false;
                    }
                    break;

                case "2":
                    running = false;
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please enter 1 or 2.");
            }
        }

        System.out.println("\nThank you for using Java Quiz!");
        sc.close();
    }
}
