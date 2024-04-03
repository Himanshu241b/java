package March_20;

import java.util.*;

class Solution {
    public static String findFourNumbers(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target)
                        return "Yes";
                    else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }

        return "No";
    }
}

public class FourSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(Solution.findFourNumbers(arr, target));
        }

        scanner.close();
    }
}

