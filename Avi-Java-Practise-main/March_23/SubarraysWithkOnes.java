import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SubarraysWithkOnes {

    public static int countSubarraysWithKOnes(int[] arr, int k) {
        int count = 0;
        int left = 0;
        int onesCount = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            // Update onesCount and frequencyMap
            if (arr[right] == 1) {
                onesCount++;
            }
            frequencyMap.put(onesCount, frequencyMap.getOrDefault(onesCount, 0) + 1);

            // If current count of ones is greater than k, move left pointer
            while (onesCount > k) {
                if (arr[left] == 1) {
                    onesCount--;
                }
                frequencyMap.put(onesCount, frequencyMap.get(onesCount) - 1);
                if (frequencyMap.get(onesCount) == 0) {
                    frequencyMap.remove(onesCount);
                }
                left++;
            }

            // If current count of ones is equal to k, update count
            if (onesCount == k) {
                count += frequencyMap.getOrDefault(k, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int N = scanner.nextInt();
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(countSubarraysWithKOnes(arr, k));
        scanner.close();
    }
}
