package Day3_30jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Find_Duplicates_in_array {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        //CREATED AND TOOK INPUT IN ARRAYLIST
        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for (int i = 1; i <= n; i++) {
            int el = sc.nextInt();
            arr.add(el);
        }

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        for(int i:arr){

            if(!m.containsKey(i)) m.put(i, 1);
            else{
                m.put(i, m.get(i)+1);
            }
        }

        for(Map.Entry<Integer, Integer> i: m.entrySet()){
            if(i.getValue() > 1){
                res.add(i.getKey());
            }
        }
        for(int i:res)System.out.print(i + " ");
    }
}
