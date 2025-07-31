package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class HighScoreTracker {
    private List<Integer> allScores;  // Stores ALL scores
    private List<Integer> topScores;  // Stores TOP 10 scores

    public HighScoreTracker() {
        allScores = new ArrayList<>();
        topScores = new ArrayList<>(Arrays.asList(95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45)); // 11 to start with
        // Keep only top 10
        allScores.addAll(topScores);
        Collections.sort(topScores, Collections.reverseOrder());
        while (topScores.size() > 10) {
            topScores.remove(topScores.size() - 1);
        }
    }

    // Adds score to both lists and trims topScores if needed
    public void addScore(int newScore) {
        allScores.add(newScore);  // Keep all history

        topScores.add(newScore);
        Collections.sort(topScores, Collections.reverseOrder());

        if (topScores.size() > 10) {
            topScores.remove(topScores.size() - 1);  // Remove the lowest
        }
    }

    // View top 10 scores
    public void viewTopScores() {
        System.out.println("\n🏆 Top 10 Scores:");
        for (int score : topScores) {
            System.out.println(score);
        }
    }
    public void searchTopScore(int score) {
    int index = topScores.indexOf(score);
    if (index != -1) {
        System.out.println("✅ Score " + score + " is ranked at position " + (index + 1) + " in Top 10.");
    } else {
        System.out.println("❌ Score " + score + " is not in the Top 10.");
    }
}


    // View all scores ever entered
    public void viewAllScores() {
        System.out.println("\n📋 All Scores Entered:");
        for (int score : allScores) {
            System.out.println(score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HighScoreTracker tracker = new HighScoreTracker();

        while (true) {
            System.out.println("\n--- High Score Tracker ---");
            System.out.println("1. Add Score");
            System.out.println("2. View All Scores Entered");
            System.out.println("3.  View Top 10 Scores");
            System.out.println("4.  Search Score in Top 10");
            System.out.println("4.  Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new score: ");
                    int newScore = sc.nextInt();
                    tracker.addScore(newScore);
                    break;
                case 2:
                    tracker.viewAllScores();
                    break;
            
                case 3:
                    tracker.viewTopScores();
                    break;
                    
                case 4:
                System.out.print("Enter score to search in Top 10: ");
                int searchScore = sc.nextInt();
                tracker.searchTopScore(searchScore);
                break;

                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
