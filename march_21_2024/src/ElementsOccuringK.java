import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementsOccuringK {
    public static void main(String[] args) {
        int[][] arrs = {{1, 1, 2, 1, 2, 4, 3, 4}, {1, 1, 1, 2, 2, 2}};
        int[] ks = {4, 6};

        for (int i = 0; i < arrs.length; i++) {
            List<Integer> result = findFrequentElements(arrs[i], ks[i]);
            System.out.println(result);
        }
    }

    public static List<Integer> findFrequentElements(int[] arr, int k) {
        int n = arr.length;
        int threshold = n / k;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check if frequency is greater than or equal to threshold
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
