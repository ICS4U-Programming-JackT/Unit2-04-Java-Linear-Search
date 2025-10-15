import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Program that generates random integers, sorts them,
 * and performs a linear search for user-input values.
 *
 * @author Jack
 * @version 1.0
 * @since 2025-10-02
 */
public final class LinearSearch {

    /** Constant for minimum random number. */
    private static final int MIN = 0;

    /** Constant for maximum random number. */
    private static final int MAX = 100;

    /** Private constructor to prevent instantiation. */
    private LinearSearch() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Returns index of target in array or -1.
     * @param target number to search for
     * @param array array to search in
     * @return index or -1
     */
    public static int linearSearch(final int target, final int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Generates an array of 10 random integers between MIN and MAX.
     * @return generated array
     */
    public static int[] setupArray() {
        final Random random = new Random();
        final int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(MAX - MIN + 1) + MIN;
        }
        return array;
    }

    /**
     * Main entry point.
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        // Setup array
        final int[] sorted = setupArray();
        Arrays.sort(sorted);

        // User interaction
        System.out.println("Array: " + Arrays.toString(sorted));
        System.out.println("Enter a number to search for (or 'q' to quit)");

        final Scanner scanner = new Scanner(System.in);

        // Loop for user input
        while (true) {
            System.out.print("Enter target: ");
            final String targetString = scanner.nextLine();

            // If user decides to quit
            if (targetString.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Try to parse input and search
            try {
                final int targetInt = Integer.parseInt(targetString);
                final int index = linearSearch(targetInt, sorted);
                if (index == -1) {
                    System.out.println(
                        "The number you entered is not in the array."
                    );
                } else {
                    System.out.println(
                        "The index of your target is " + index + "."
                    );
                }
            } catch (NumberFormatException e) {
                // If input is not a valid integer
                System.out.println(
                    "Invalid input. Please enter a number or 'q' to quit."
                );
            }
        }

        // Close the scanner
        scanner.close();
    }
}
