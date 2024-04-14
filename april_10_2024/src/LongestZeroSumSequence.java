import java.util.*;

public class LongestZeroSumSequence {
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;

        map.put(0, -1); // Handle case when sum becomes 0 at index 0

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = map.get(sum) + 1;
                }
            } else {
                map.put(sum, i);
            }
        }

        if (startIndex != -1) {
            for (int i = startIndex; i < startIndex + maxLength; i++) {
                result.add(A.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int N = scanner.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }

        ArrayList<Integer> result = lszero(A);
        System.out.println("The longest continuous sequence with total sum of zero is: " + result);
    }
}
