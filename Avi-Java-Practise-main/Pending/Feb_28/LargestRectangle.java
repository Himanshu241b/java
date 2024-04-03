package org.example;

import java.util.Scanner;

public class LargestRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //taking input the Array of Height of Histogram
        System.out.println("Enter the Array size : ");
        int size = sc.nextInt();
        int[] HeightArray = new int[size];
        System.out.println("Enter the Heights of the Histogram ");
        for (int heigts = 0; heigts < HeightArray.length; heigts++) {
            HeightArray[heigts] = sc.nextInt();
        }

        int finalarea = 0;

        //traversing over the height array
        for (int heights = 0; heights < HeightArray.length; heights++) {
            int left = heights;
            int right = heights;

            //checking for  previous small
            while (left>0 && HeightArray[left-1] >= HeightArray[heights])
                left--;

            //checking for next small
            while (right<HeightArray.length-1 &&  HeightArray[right+1] >= HeightArray[heights])
                right++;

            //checking for the largest FinalArea Produced
            finalarea = Math.max(finalarea, (right - left + 1) * HeightArray[heights]);


        }
        System.out.println(finalarea);
    }
}