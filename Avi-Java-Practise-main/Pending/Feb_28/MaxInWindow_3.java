package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxInWindow_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //taking array Input
        System.out.println("Enter the size of the array : ");
        int size=sc.nextInt();
        int[] Array=new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int element=0;element<size;element++)
            Array[element]=sc.nextInt();

        //taking input window size
        System.out.println("Enter the Window size : ");
        int WindowSize= sc.nextInt();


        //making an  Arraylist to store the Max in window
        ArrayList<Integer> solution=new ArrayList<>();


        //traversing in the array up to the possible windows
        for(int element=0;element<=size-WindowSize;element++)
        {
            int max=Array[element];

            //traversing each window to calculate the max
            for(int WindowE=element+1;WindowE<element+WindowSize;WindowE++)
            {
               if(Array[WindowE]>max)
               {
                   max=Array[WindowE];     //comparing each element of window to obtain maix
               }
            }
            solution.add(max);                  //adding max of window to the resultant array

        }
        System.out.println(solution);

    }
}
