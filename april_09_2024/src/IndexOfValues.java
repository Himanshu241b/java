import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IndexOfValues {
    public static ArrayList<Integer> findIndices(int[] A) {
        int n = A.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = map.get(sum);
                    list.add(i);
                    list.add(j);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = map.get(sum);
                    for (int k = 0; k < list.size(); k += 2) {
                        int p = list.get(k);
                        int q = list.get(k + 1);
                        if (p != i && p != j && q != i && q != j) {
                            return new ArrayList<>(List.of(i, j, p, q));
                        }
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 7, 1, 2, 9, 8};
        ArrayList<Integer> indices = findIndices(A);
        System.out.println(indices); // Output should be [0, 2, 3, 5]

        int[] B = {2, 5, 1, 6};
        indices = findIndices(B);
        System.out.println(indices); // Output should be [0, 1, 2, 3]
    }
}
