import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * CSC515HW1
 */
public class CSC515HW1 {
    public static void main(String[] args) {

        // ***************** Prblem 1 ******************

        // Prom user to enter a string
        System.out.print("Please enter some text: ");
        // Read input
        var scanner = new Scanner(System.in);
        var inputString = scanner.nextLine();
        var vowelCounter = VowelCount(inputString);
        // Print result
        System.out.println("Number of vowel(s) in input text: " + vowelCounter);

        // ***************** Prblem 2 ******************
        // Prom user to enter a string
        System.out.print("Please enter an integer: ");
        // Read input
        inputString = scanner.nextLine();
        // Try catch to see if input is an integer
        try {
            var inputInt = Integer.parseInt(inputString);
            // Check if the integer is positive
            if (inputInt > 0) {
                if (inputInt % 3 == 0) {
                    System.out.println(inputInt + " is divisible by 3");
                } else {
                    System.out.println(inputInt + " is not divisible by 3");
                }
            } else {
                // the integer is negative
                System.out.println(inputInt + " is negative");
            }
        } catch (Exception ex) {
            System.out.println(inputString + " is not an integer");
        }

        scanner.close();
        // ***************** Prblem 3 ******************

        // Open and read input file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            vowelCounter = 0;
            // Print out the file and count how many vowels in the file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                vowelCounter += VowelCount(line);
            }
            System.out.println("Number of vowel(s) in input file: " + vowelCounter);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    // Count how many vowel in a string
    public static int VowelCount(String inputString) {
        int vowelCounter = 0;
        for (var character : inputString.toCharArray()) {
            // Check if the character is vowel
            if (character == 'a' || character == 'A' || character == 'e' || character == 'E' || character == 'i'
                    || character == 'I' || character == 'o' || character == 'O' || character == 'u'
                    || character == 'U') {
                vowelCounter++;
            }
        }
        return vowelCounter;
    }
}
