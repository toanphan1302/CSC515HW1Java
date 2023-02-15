public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };

        // Print out the array
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");

            }
        }

        CalculateMaxSubArray(arr);
    }

    static void CalculateMaxSubArray(int[] arr) {
        // initialize state
        int startInd = 0;
        int endInd = 0;
        int movingInd = 0;

        // Set maxSoFar = mininum value of integer
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i]; // update sum of the array

            // Update maxSoFar if there is a new max
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                endInd = i;
                startInd = movingInd;
            }

            // Reset maxEndingHere if it is negative
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                movingInd += 1;
            }
        }

        // Print out result
        System.out.println("Maximum sub array sum: " + maxSoFar);
        System.out.println("Start Index: " + startInd + "\tEnd Index: " + endInd);

    }
}
