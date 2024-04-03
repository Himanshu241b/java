package Feb_23;

import java.util.*;

public class Calc_mv_avg {
    //You are processing time series data. You want to write a function called calc_mov_avg that takes three arguments: size (the size of the input vector), vect (a vector of integers) and window_size (an integer representing the size of the window for calculating the moving average). The function should return a vector, result, of moving averages, where each element of the resulting vector is the average of a window of consecutive window_size elements from the input vect. It should also return n, the size of the result vector. If the resulting moving average is a floating- point number, it should be rounded to the nearest integer.
    //Assumptions:
    //• The window size is always a natural number.
    //• The input vector is guaranteed to be non- empty.
    //
    //Example 1
    //Input:
    //⚫ size = 4
    //• vect = 1234
    //⚫ window_size = 3
    //Output:
    //n = 2
    //• result = 23
    //Explanation:
    //• The first window is 1 2 3 with an average of 2
    //• The second window is 2 3 4 with an average of 3
    //• Hence the output is 2 3
    //Example 2
    //Input:
    //. size = 4
    //• vect = 1234
    //window_size = 2
    //Output:
    //n = 3
    //• result = 234
    //
    //Explanation:
    //• The first window is 1 2 with an average of 1.5 which should be rounded to 2
    //• The second window is 2 3 with an average of 2.5 which should be rounded to 3
    //• The third window is 3 4 with an average of 3.5, which should be rounded to 4
    //• Hence the output is 2 3 4

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5 , 6};

        int windowSize = 3;
        int ans = 0;
        int i=0;
        while(i < arr.length-windowSize+1)
        {
            int avg = 0;
            int j=i;
            while(j < arr.length && j < i+windowSize)
            {
                avg += arr[j++];
            }
            avg /= windowSize;
            ans = ans*10 + avg;
            i++;
        }
        System.out.println(ans);
    }

}
