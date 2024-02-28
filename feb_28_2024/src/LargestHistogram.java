//imports
import java.util.Scanner;
import java.util.Stack;
class LargestHistogram{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array:");
        int size = sc.nextInt();
        int[] heights = new int[size];
        System.out.println("Enter "+size+" elements of arrray:");
        for(int i = 0; i < size; i++){
            heights[i] = sc.nextInt();
        }
        System.out.println("Max area:"+ findMaxHistogram(heights));
    }
    public static int findMaxHistogram(int[] heights){
        // make a stack to hold index of previous smallest and next smallest heights
        Stack<Integer> stack = new Stack<Integer>();
        //make two arrays to store indices of previous and next smallest histograms
        int[] prevSmallest = new int[heights.length];
        int[] nextSmallest = new int[heights.length];

        // fill the prevSmallest array
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) //if previous smalllest index has equal or more height pop it and look for next index in stack
                stack.pop();
            if(stack.isEmpty())
                prevSmallest[i] = 0;
            else
                prevSmallest[i] = stack.peek()+1;
            stack.push(i);
        }
        //fill the nextSmallest array
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) //if next smalllest index has equal or more height pop it and look for next index in stack
                stack.pop();
            if(stack.isEmpty())
                nextSmallest[i] = heights.length-1;
            else
                nextSmallest[i] = stack.peek()-1;
            stack.push(i);
        }
        //calculate the max area
        int maxArea = 0;
        for(int i = 0; i < heights.length;++i){
            int area = heights[i] * (nextSmallest[i] - prevSmallest[i] +1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}