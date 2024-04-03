package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


class OrderofHeights{
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of heights array:");
        int size = scanner.nextInt();
        int[] heights = new int[size];
        int[] infronts = new int[size];
        System.out.println("Enter heigts array elements:");
        for (int heightsIndex = 0; heightsIndex < size; heightsIndex++)
            heights[heightsIndex] = scanner.nextInt();
        System.out.println("Enter infronts array elements:");
        for(int infrontsIndex = 0; infrontsIndex < infronts.length; infrontsIndex++)
            infronts[infrontsIndex] = scanner.nextInt();



        ArrayList<Integer> orderedPeople = orderPeople(heights, infronts);
        for(int i = 0; i < orderedPeople.size(); i++)
            System.out.print(orderedPeople.get(i).toString());
    }
    public static ArrayList<Integer> orderPeople(int[] heights, int[] infronts){
        int n = heights.length;

        // Create pairs of heights and infronts
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = heights[i];
            people[i][1] = infronts[i];
        }

        // Sort the pairs based on heights and infronts
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // Sort heights in descending order
            } else {
                return Integer.compare(a[1], b[1]); // Sort infronts in ascending order
            }
        });

        // Insert each person into the result list at the specified position
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person[0]);
        }

        return result;
    }
}
