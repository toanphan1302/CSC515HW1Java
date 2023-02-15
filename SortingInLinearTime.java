import java.io.Console;
import java.nio.file.ClosedWatchServiceException;
import java.util.Arrays;
import java.util.Random;

/*This code will only implement Counting and Radix sort*/
public class SortingInLinearTime {
    public static void main(String[] args) {
        int size = 10;
        int max = 999;
        int[] arr = new int[size];
        GenerateRandomIntArray(arr, max);
        PrintArray(arr);
        CountingSort(arr, max);
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
}
