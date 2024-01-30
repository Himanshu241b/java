import java.util.Scanner;
class mergesort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted array:");
        for(int i = 0; i < n; i++){
            System.out.print(" "+arr[i]);
        }
        }
    public static void mergeSort(int[] nums, int l, int r){
        if(l == r)
            return;
        
        int mid = (l +r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);   
    }
public static void merge(int[] nums, int l, int mid, int r){
    int i = l, j = mid+1, k = 0;
    int temp[] = new int[r-l+1];

    while(j <= r && i <= mid){
        if(nums[j] < nums[i])
            temp[k++] = nums[j++];
        else
            temp[k++] = nums[i++];
    }
    while(j <= r)
        temp[k++] = nums[j++];
    
    while(i <= mid)
        temp[k++] = nums[i++];

    for(int x = 0, y = l; x<temp.length; x++,y++)
        nums[y] = temp[x];
}
}