package cricket.game;

import java.util.Scanner;

// Java program to generate random numbers
// according to given frequency distribution
public class Util {

    // Utility function to find ceiling of r in arr[l..h]
    static int findCeil(int[] arr, int r, int l, int h) {
        int mid;
        while (l < h) {
            mid = l + ((h - l) >> 1); // Same as mid = (l+h)/2
            if (r > arr[mid])
                l = mid + 1;
            else
                h = mid;
        }
        return (arr[l] >= r) ? l : -1;
    }

    // The main function that returns a random number
    // from arr[] according to distribution array
    // defined by freq[]. n is size of arrays.
    static int myRand(int[] arr, int[] freq, int n) {
        // Create and fill prefix array
        int[] prefix = new int[n];
        int i;
        prefix[0] = freq[0];
        for (i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + freq[i];

        // prefix[n-1] is sum of all frequencies.
        // Generate a random number with
        // value from 1 to this sum
        int r = ((int) (Math.random() * (323567)) % prefix[n - 1]) + 1;

        // Find index of ceiling of r in prefix array
        int index_c = findCeil(prefix, r, 0, n - 1);
        return arr[index_c];
    }

    public static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
    public static int[] freq = {20, 30, 25, 5, 2, 0, 1, 20};
    public static int[] toss_outcome = {0, 1};
    public static int[] freq_outcome = {50, 50};

    public int takeInputInteger() {
        Scanner inputObj = new Scanner(System.in);
        return inputObj.nextInt();
    }

    public String takeInputString() {
        Scanner inputObj = new Scanner(System.in);
        return inputObj.nextLine();
    }


}


