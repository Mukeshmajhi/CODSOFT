package Task2;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	public class WordCount 
	  {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Prompt the user for input (text or file)
	        System.out.println("Word Count Program");
	        System.out.println("Choose an option:");
	        System.out.println("1. Enter text");
	        System.out.println("2. Provide a file");
	        System.out.print("Enter your choice (1/2): ");

	        int choice = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character

	        String text = "";

	        if (choice == 1) {
	            // Read text from the user
	            System.out.print("Enter your text: ");
	            text = scanner.nextLine();
	        } else if (choice == 2) {
	            // Read text from a file
	            System.out.print("Enter the file path: ");
	            String filePath = scanner.nextLine();
	            try {
	                text = readTextFromFile(filePath);
	            } catch (IOException e) {
	                System.err.println("Error reading the file: " + e.getMessage());
	                return;
	            }
	        } else {
	            System.err.println("Invalid choice. Please enter 1 or 2.");
	            return;
	        }

	        // Split the text into words using space and punctuation as delimiters
	        String[] words = text.split("[\\s\\p{Punct}]+");

	        // Initialize variables for word count and a map to store word frequencies
	        int wordCount = words.length;
	        Map<String, Integer> wordFrequency = new HashMap<>();

	        for (String word : words) {
	            // Convert the word to lowercase and remove leading/trailing spaces
	            word = word.toLowerCase().trim();

	            // Ignore common words (you can expand this list as needed)
	            if (!isCommonWord(word)) {
	                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
	            }
	        }

	        // Display word count
	        System.out.println("Total word count: " + wordCount);

	        // Display word frequency statistics
	        System.out.println("Word Frequency Statistics:");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
	        }

	        scanner.close();
	    }

	    // Read text from a file
	    private static String readTextFromFile(String filePath) throws IOException {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append(" ");
	            }
	        }
	        return content.toString();
	    }

	    // Common words to ignore (you can expand this list)
	    private static boolean isCommonWord(String word) {
	        String[] commonWords = {"the", "and", "in", "of", "a", "to", "is"};
	        return Arrays.asList(commonWords).contains(word);
	    }
	}
