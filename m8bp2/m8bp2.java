import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class m8bp2 {

    // Load responses from a file
    private static List<String> loadResponses(String filePath) {
        List<String> responses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                responses.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading responses file: " + e.getMessage());
        }
        return responses;
    }

    // Get a random response
    private static String getRandomResponse(List<String> responses) {
        Random random = new Random();
        return responses.get(random.nextInt(responses.size()));
    }

    public static void main(String[] args) {
        List<String> responses = loadResponses("responses.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ask your question (or type 'quit' to exit): ");
            String question = scanner.nextLine();

            if (question.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println("Thinking...");
            try {
                Thread.sleep(2000); // Simulating thinking time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String answer = getRandomResponse(responses);
            System.out.println("The Magic 8 Ball says: " + answer);

            
        }

        scanner.close();
    }
}