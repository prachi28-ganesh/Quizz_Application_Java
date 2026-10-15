
package quizzapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();

        questions.add(new Question(
            "Which keyword is used to create a class in Java?",
            new String[]{"method", "class", "object", "new"}, 2));

        questions.add(new Question(
            "Which method is the entry point of a Java program?",
            new String[]{"start()", "run()", "main()", "init()"}, 3));

        questions.add(new Question(
            "Which data type stores true or false?",
            new String[]{"int", "char", "boolean", "double"}, 3));

        questions.add(new Question(
            "Which keyword is used for inheritance in Java?",
            new String[]{"this", "super", "extends", "implements"}, 3));

        questions.add(new Question(
            "Which collection does not allow duplicate elements?",
            new String[]{"List", "Set", "ArrayList", "Queue"}, 2));
    }

    public void start(Scanner sc) {

        int score = 0;
        int questionNumber = 1;

        System.out.println("\n========== QUIZ STARTED ==========");

        for (Question q : questions) {

            System.out.println("\nQuestion " + questionNumber
                    + ": " + q.getQuestionText());

            String[] options = q.getOptions();

            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int answer = readAnswer(sc);

            if (q.isCorrect(answer)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
                System.out.println("Correct answer: "
                        + q.getCorrectOption());
            }

            questionNumber++;
        }

        showResult(score);
    }

    private int readAnswer(Scanner sc) {

        while (true) {
            System.out.print("Enter your answer (1-4): ");
            String input = sc.nextLine().trim();

            try {
                int answer = Integer.parseInt(input);

                if (answer >= 1 && answer <= 4) {
                    return answer;
                }

                System.out.println("Please enter a number from 1 to 4.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private void showResult(int score) {

        int total = questions.size();
        double percentage = score * 100.0 / total;

        System.out.println("\n========== FINAL RESULT ==========");
        System.out.println("Total Questions : " + total);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (total - score));
        System.out.printf("Percentage      : %.2f%%%n", percentage);

        if (percentage >= 80) {
            System.out.println("Grade: Excellent!");
        } else if (percentage >= 50) {
            System.out.println("Grade: Good!");
        } else {
            System.out.println("Grade: Keep Practicing!");
        }

        System.out.println("==================================");
    }
}
