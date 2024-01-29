import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class arrayoccurancein3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] array = new int[n];

        System.out.println("Enter elements of array");
        for(int i = 0; i <n; i++) {
            array[i] = sc.nextInt();
        }

        for(int i = 0; i < n; ++i){
            map.put(array[i], map.getOrDefault(array[i],0 )+1);
        }
        map.forEach((k, v)->{
            if(map.get(k) == 1)
                System.out.println(k);
        });
    }
}