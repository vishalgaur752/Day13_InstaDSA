import java.util.*;

public class AggressiveCows {
    public static int aggeressiveCow(int arr[], int n, int cows) {
        if (arr.length < cows) {
            return -1;
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr[n - 1] - arr[0];
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAllocatedPossible(arr, mid, cows)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isAllocatedPossible(int arr[], int minDist, int cows) {
        int cowsCount = 1;
        int dist = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - dist >= minDist) {
                cowsCount += 1;
                dist = arr[i];
            }
            if (cowsCount >= cows) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 9 };
        int n = arr.length;
        int cows = 3;
        System.out.println(aggeressiveCow(arr, n, cows));
    }
}