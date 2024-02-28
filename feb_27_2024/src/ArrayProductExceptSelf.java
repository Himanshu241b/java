//imports
import java.util.Scanner;
class ArrayProductExceptSelf{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();    //size of input array
        int[] array = new int[size];    //declare array
        System.out.println("Enter "+size+"array elements:");
        for(int i = 0;i < size;i++)
            array[i] = sc.nextInt();    //takes user input
        int [] res = findResultArray(array);
        for(int i = 0;i < size; ++i)    //prints result
            System.out.println(res[i]);
    }

    /**
     * method to find the array of product except self
     * @param nums input arrray
     * @return result array
     */
    public static int[] findResultArray(int[] nums) {
            int ans[] = new int[nums.length];
            int temp =1;
            for(int i =0 ; i< nums.length; ++i){ // iterates from beginning to last element
                ans[i] = temp;
                temp *= nums[i];
            }
            temp = 1;
            for(int i = nums.length-1; i>=0; --i){  //iterates from last to beginning and updates the array
                ans[i] *= temp;     // multiply array element to temp
                temp *= nums[i];    //change value of temp
            }
            return ans;
        }
    }
