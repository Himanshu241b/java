import java.util.Scanner;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arraylength1 = nums1.length;
        int arraylength2 = nums2.length;
        int[] merged = new int[arraylength1 + arraylength2];
        int i = 0, j = 0, k = 0;

        while (i < arraylength1 && j < arraylength2) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < arraylength1) {
            merged[k++] = nums1[i++];
        }

        while (j < arraylength2) {
            merged[k++] = nums2[j++];
        }

        int totalLength = arraylength1 + arraylength2;
        if (totalLength % 2 == 0) {
            int mid1 = merged[totalLength / 2 - 1];
            int mid2 = merged[totalLength / 2];
            return (double) (mid1 + mid2) / 2.0;
        } else {
            return merged[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        System.out.print("Enter the elements of the first array: ");
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        System.out.print("Enter the elements of the second array: ");
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            nums2[i] = scanner.nextInt();
        }

        // Call the function and print the result
        System.out.println("Median of the two sorted arrays: " + findMedianSortedArrays(nums1, nums2));

        scanner.close();
    }
}
