//imports
import java.util.ArrayList;
import java.util.Scanner;

public class MaxOnes {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int left = 0;
        int right = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (right < A.size()) {
            // when new element in window is 0 increase zerocount

            //if zerocount is greater than what we can flip decrease window size
            while (zeroCount > B) {
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;     if (A.get(right) == 0) {
                    zeroCount++;
                }
            }
            //if we get a new maxlength change previous value and also maxleft and maxright index of window
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                maxLeft = left;
                maxRight = right;
            }

            right++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxLeft; i <= maxRight; i++) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxOnes maxOnes = new MaxOnes();

        System.out.println("Enter size of array:");
        int size = sc.nextInt();
        ArrayList<Integer> A1 = new ArrayList<>(size);
        System.out.println("Enter the "+size+" elements of the array");
        for(int a1Index = 0; a1Index <size; a1Index++) {
            A1.add(sc.nextInt());
        }
        System.out.println("Enter the number of 0's you can replace:");
        int B1 = sc.nextInt();
        System.out.println(maxOnes.maxone(A1, B1));


    }
}
