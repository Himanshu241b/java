import java.io.*;
import java.util.*;
import java.lang.*;
public class Day2 {

    public static void merge(ArrayList<Integer> arr, int l, int m, int r)
    {
        int i = l;
        int k = l;
        int j = m+1;

        int[] B = new int[r-l+1];

        while(i <= m && j <= r)
        {
            if(arr.get(i) < arr.get(j)) B[k++] = arr.get(i++);
            else B[k++] = arr.get(j++);
        }
        while(i <= m)
        {
            B[k++] = arr.get(i++);
        }
        while(j <= r)
        {
            B[k++] = arr.get(j++);
        }

        for(int it=l; it<=r; it++)
        {
            arr.set(it, B[it]);
        }
    }
    public static void mergeSort(ArrayList<Integer> arr, int l, int r)
    {
        if(l >= r) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);

        merge(arr, l, m, r);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        //CREATED AND TOOK INPUT IN ARRAYLIST
        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for(int i=1; i<=n; i++)
        {
            int el = sc.nextInt();
            arr.add(el);
        }


        //CREATED AND INPUTED 2D ARRAYLIST
        ArrayList<ArrayList<Integer>> mtx = new ArrayList<ArrayList<Integer>>();


        //1. Given an array/list(ARR) of length N, you need to find and return the sum of all the elements in the array/list.
//        int sum = 0;
//        for(int i: arr) sum += i;
//        System.out.print(sum);
//
//
////        Given an array/list 'ARR' of integers and a position ‘M’. You have to reverse the array after that position.
//
//        System.out.println("Enter the position value");
//        int m = sc.nextInt();
//        int j = arr.size() - 1;
//
//        for(int i=m+1; i<arr.size() && i < j; i++)
//        {
//            int temp = arr.get(i);
//            arr.set(i, arr.get(j));
//            arr.set(j, temp);
//            j--;
//        }


//        3. You are given an arbitrary array ‘arr’ consisting of N non-negative integers, where every element appears thrice except one. You need to find the element that appears only once.
//        Map <Integer, Integer> m = new HashMap<>();
////
//        for(int i=0; i<arr.size(); i++)
//        {
//            if(m.containsKey(arr.get(i))){
//                m.put(arr.get(i), arr.get(arr.get(i))+1);
//            }
//            else{
//                m.put(arr.get(i), 1);
//            }
//        }
//        for(Map.Entry<Integer, Integer> i: m.entrySet())
//        {
//            if(i.getValue() == 1) {
//                System.out.println(i.getKey());
//                break;
//            }
//        }


//        4. You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
//        Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
//        You need to find and return that number which is unique in the array/list

//        Map <Integer, Integer> m = new HashMap<>();
//
//        for(int i=0; i<arr.size(); i++)
//        {
//            if(m.containsKey(arr.get(i))){
//                m.put(arr.get(i), arr.get(arr.get(i))+1);
//            }
//            else{
//                m.put(arr.get(i), 1);
//            }
//        }
//        for(Map.Entry<Integer, Integer> i: m.entrySet())
//        {
//            if(i.getValue() == 1) {
//                System.out.println(i.getKey());
//                break;
//            }
//        }


//        5. You are given a number ‘N’ and a query ‘Q.’ If ‘Q’ is 1, then you have to return the sum of all integers from 1 to ‘N,’ else if ‘Q’ is equal to 2 then you have to return the product of all integers from 1 to ‘N.’ Since the product can be very large, return it modulo 10 ^ 9 + 7.

//        System.out.println("Enter the value of n");
//        int N = sc.nextInt();
//
//        System.out.println("Enter the query number you want to perform");
//        int q = sc.nextInt();
//
//        if(q == 1)
//        {
//            int sum = (N * (N+1)) / 2;
//            System.out.println("Sum is " + sum);
//        }
//        else if(q == 2)
//        {
//            int prod = 1;
//            for(int i=1; i<=N; i++)
//            {
//                prod = (prod * i) % 100000007;
//            }
//            System.out.println("Product is " + prod);
//        }


//        ASSIGNMENT-----------------------------------------------------------------------------------------


//        1.You are given an array/list ARR consisting of N integers. Your task is to find all the distinct triplets present in the array which adds up to a given number K.
//        An array is said to have a triplet {ARR[i], ARR[j], ARR[k]} with sum = 'K' if there exists three indices i, j and k such that i!=j, j!=k and i!=j and ARR[i] + ARR[j] + ARR[k] = 'K'.
//        System.out.println("Enter the target value");
//        int target = sc.nextInt();

        //SORTING METHOD
//        Collections.sort(arr);
//
//        for(int i=0; i<arr.size()-2; i++)
//        {
//            int l = i+1;
//            int r = arr.size() - 1;
//
//            while(l < r)
//            {
//                int sum = arr.get(i) + arr.get(l) + arr.get(r);
//                if(sum == target)
//                {
//                    System.out.println(arr.get(i) + " " + arr.get(l) + " " + arr.get(r));
//                    break;
//                }
//                else if(sum > target) r--;
//                else l++;
//            }
//        }


        //2. You are given a sorted integer array 'arr' of size 'n'.
        //You need to remove the duplicates from the array such that each element appears only once.
//        int j = 0;
//        for(int k=0; k<arr.size()-1; k++)
//        {
//            System.out.println(arr.get(k) + " k " + k);
//            if(!Objects.equals(arr.get(k), arr.get(k + 1))) arr.set(j++, arr.get(k));
//        }
//        arr.set(j++, arr.get(arr.size()-1));


        //3. You are given an array of size ‘N’. The elements of the array are in the range from 1 to ‘N’.
        //Ideally, the array should contain elements from 1 to ‘N’. But due to some miscalculations, there is a number R in the range [1, N] which appears in the array twice and another number M in the range [1, N] which is missing from the array.
//        Your task is to find the missing number (M) and the repeating number (R).
//        int dup = 0, missing = 0;
//        int ogSum = n*(n+1)/2;
//        int sum = 0;
//        for(int i: arr) sum += i;
//
//        for(int i=0; i<arr.size(); i++)
//        {
//            int index = Math.abs(arr.get(i))-1;
//            if(arr.get(index) > 0){
//                arr.set(index, -arr.get(index));
//            }
//            else {
//                dup = Math.abs(arr.get(i));
//            }
//        }
//        for(int i=0; i<n; i++)
//        {
//            if(arr.get(i) > 0) missing = i+1;
//        }
//        System.out.println("Duplicate number is: " + dup + "\nMissing number is: " + missing);


//        4. You have been given an integer array/list (ARR) of size N. You have to return an array/list PRODUCT such that PRODUCT[i] is equal to the product of all the elements of ARR except ARR[i]

//        int product = 1;
//        for(int i: arr) product *= i;
//        for(int i=0; i<arr.size(); i++)
//        {
//            arr.set(i, product/arr.get(i));
//        }


//        5. Sum Of Infinite Array
//Given an array “A” of N integers and you have also defined the new array “B” as a concatenation of array “A” for an infinite number of times.
//        System.out.println("Enter l");
//        int l = sc.nextInt();
//        System.out.println("Enter r");
//        int r = sc.nextInt();
//
//        int sum = 0;
//
//        for(int i=l; i<=r; i++)
//        {
//            sum = sum + arr.get((i%n));
//        }
//        System.out.println(sum);


//      6. You are given two numbers 'A' and 'B' in the form of two arrays (A[] and B[]) of lengths 'N' and 'M' respectively, where each array element represents a digit. You need to find the sum of these two numbers and return this sum in the form of an array.

//        ArrayList<Integer> arr2 = new ArrayList<Integer>();
//
//        System.out.println("Enter the 2nd array size value");
//        int n2 = sc.nextInt();
//
//
//        System.out.println("Enter the elements of 2nd array");
//        for(int i=1; i<=n2; i++)
//        {
//            int el = sc.nextInt();
//            arr2.add(el);
//        }
//        int k = n-1;
//        int j = n2-1;

        //resultant array
//        ArrayList<Integer> sumArr = new ArrayList<>();
//        int carry = 0;
//
//        while(k >=0 && j >=0)
//        {
//            int digitSum = arr.get(k--) + arr2.get(j--) + carry;
//            if(digitSum >= 10) carry = 1;
//            else carry = 0;
//            sumArr.add(digitSum%10);
//        }
//        while(k >=0)
//        {
//            int digitSum = arr.get(k--) + carry;
//            if(digitSum >= 10) carry = 1;
//            else carry = 0;
//            sumArr.add(digitSum%10);
//        }
//        while(j >= 0)
//        {
//            int digitSum = arr.get(j--) + carry;
//            if(digitSum >= 10) carry = 1;
//            else carry = 0;
//            sumArr.add((digitSum%10) + carry);
//        }
//        Collections.reverse(sumArr);
//        for(int i:sumArr) System.out.print(i + " ");



//        7. K Largest Element
//        You are given an unsorted array containing ‘N’ integers. You need to find ‘K’ largest elements from the given array. Also, you need to return the elements in non-decreasing order.

//        System.out.println("Enter the value of k");
//        int k = sc.nextInt();
//
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//
//        for(int i=0; i<n; i++)
//        {
//            pq.add(arr.get(i));
//            if(pq.size() > k)
//            {
//                pq.poll();
//            }
//        }
//
//        while(!pq.isEmpty())
//        {
//            System.out.print(pq.peek() + " ");
//            pq.poll();
//        }
//        System.out.println();


//        8. Merge K Sorted Arrays
//        You have been given ‘K’ different arrays/lists, which are sorted individually (in ascending order). You need to merge all the given arrays/list such that the output array/list should be sorted in ascending order.



//        9. Longest Consecutive Sequence
//You are given an unsorted array/list 'ARR' of 'N' integers. Your task is to return the length of the longest consecutive sequence.
//The consecutive sequence is in the form ['NUM', 'NUM' + 1, 'NUM' + 2, ..., 'NUM' + L] where 'NUM' is the starting integer of the sequence and 'L' + 1 is the length of the sequence.

//        Set<Integer> s = new HashSet<Integer>();
//        for(int i=0; i<n; i++) s.add(arr.get(i));  //updating values in set
//
//        ArrayList<Integer> res = new ArrayList<>();
//        int maxLen = 0;
//        for(int i=0; i<n; i++)
//        {
//            if(!s.contains(arr.get(i)-1)){
//                int len = 0;
//
//                while(s.contains(arr.get(i) + len)) len++;
//                maxLen = Math.max(maxLen, len);
//            }
//
//        }
//        System.out.println(maxLen);



//        10. SELECTION SORT

//        for(int i=0; i<n; i++)
//        {
//            int mini = arr.get(i);
//            int miniPos = i;
//
//            for(int j = i; j<n; j++)
//            {
//                if(mini > arr.get(j)){
//                    mini = arr.get(j);
//                    miniPos = j;
//                }
//            }
//            Collections.swap(arr, miniPos, i);
//        }



//        11. Merge Sort

//        mergeSort(arr, 0, n-1);


//        12. Insertion Sort

//        int[] a = {3, 2, 1, 5, 4};
//        for(int i=1; i<arr.size(); i++)
//        {
//            int temp = arr.get(i);
//            int j = i-1;
//            while(j >= 0 && temp < arr.get(j)){
//                arr.set(j+1, arr.get(j));
//                j--;
//            }
//            arr.set(j+1, temp);
//        }
//        for(int i: a) System.out.print(i + " ");


//        13. Search Insert
//        PositionYou are given a sorted array 'arr' of distinct values and a target value 'm'.
//You need to search for the index of the target value in the array.
//        System.out.println("Enter the value of m");
//        int m = sc.nextInt();
//
//        int s=0, j=n-1, mid = (s+j)/2;
//        boolean found = false;
//        while(s < j)
//        {
//            if(arr.get(mid) == m) {
//                System.out.println(mid);
//                found = true;
//                break;
//            }
//            else if(arr.get(mid) > m) j = mid - 1;
//            else s = mid+1;
//
//            mid = (s+j)/2;
//        }
//        if(!found) System.out.println(-1);



        //14. Bubble Sort
//        boolean swapped = false;
//            for(int i=0; i<n; i++)
//            {
//                swapped = false;
//                for(int j=0; j<n-i-1; j++)
//                {
//                    if(arr.get(j) > arr.get(j+1)) Collections.swap(arr, j, j+1);
//                    swapped = true;
//                }
//                if(!swapped) break;
//            }


        //print arraylist
        for(int i:arr) System.out.print(i + " ");

        //print 2d arraylist
//        for(ArrayList<Integer> i: mtx)
//        {
//            for(int j: i) System.out.print(j + " ");
//            System.out.println();
//        }
    }
}
