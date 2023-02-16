import java.io.Console;
import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*This code will only implement Counting and Radix sort*/
public class SortingInLinearTime {
    public static void main(String[] args) {
        int size = 10;
        int max = 9999;
        int[] arr = new int[size];
        GenerateRandomIntArray(arr, max);
        PrintArray(arr);
        CountingSort(arr, max);
        PrintArray(arr);

        System.out.println("-------------------------------------------------------------");
        GenerateRandomIntArray(arr, max);
        PrintArray(arr);
        LSDRadixSort(arr, 4);
        PrintArray(arr);
    }

    static void GenerateRandomIntArray(int[] arr, int max) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, max);
        }
    }

    static void PrintArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }

    // If number range is 0 - 1000 --> posibleMax = 1000
    static void CountingSort(int[] arr, int posibleMax) {
        System.out.println("Counting Sort");

        int[] buckets = new int[posibleMax];
        // Put numbers in buckets
        for (int number : arr) {
            buckets[number]++;
        }

        // put numbers from bukets back to array
        int arrayIndex = 0;
        for (int bucketIndex = 0; bucketIndex < posibleMax; bucketIndex++) {
            while (buckets[bucketIndex] > 0) {
                arr[arrayIndex] = bucketIndex;
                arrayIndex++;
                buckets[bucketIndex]--;
            }
        }
    }

    static void LSDRadixSort(int[] arr, int numberOfDigits) {
        System.out.println("LSB Radix Sort");
        // Create 10 - buckets represent digit from 0 ~ 9
        ArrayList<Integer>[] buckets = new ArrayList[10];
        // Initialize each bucket array list every new iteration
        for (int j = 0; j < 10; j++) {
            buckets[j] = new ArrayList<Integer>();
        }

        // Iterate through everry digit of number in the array
        for (int i = 0; i < numberOfDigits; i++) {

            for (int arrIndex = 0; arrIndex < arr.length; arrIndex++) {

                // Get current digit for the number
                int currentDigit = (arr[arrIndex] / ((int) (Math.pow(10, i)))) % 10;
                // Put number into appropriate buckets
                buckets[currentDigit].add(arr[arrIndex]);
            }

            // Put numbers in buckets back to array
            int arrIndex = 0;
            for (int bucketIndex = 0; bucketIndex < 10; bucketIndex++) {
                for (int number : buckets[bucketIndex]) {
                    arr[arrIndex] = number;
                    arrIndex++;
                }
                // empty the bucket
                buckets[bucketIndex].clear();
            }
        }
    }
}
