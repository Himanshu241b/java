package March_28;
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        // Ensure array 'a' is smaller in size compared to 'b'
        if (n > m) {
            return findMedianSortedArrays(b, a);
        }

        int left = 0;
        int right = n;
        int medianIndex = (n + m + 1) / 2;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = medianIndex - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        // If input arrays are not sorted
        return 0.0;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {{2, 4, 6}, {1, 3, 5}},
                {{2, 4, 6}, {1, 3}},
                {{1, 2, 2}, {2, 4, 4}}
        };

        for (int[][] testCase : testCases) {
            int[] a = testCase[0];
            int[] b = testCase[1];
            System.out.println(findMedianSortedArrays(a, b));
        }
    }
}

