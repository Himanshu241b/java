import java.util.Scanner;


public class CountSmallerElements {

    public static int[] countSmallerElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int[] indices = new int[n];
        int[] temp = new int[n];
        int[] tempIndices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(arr, indices, temp, tempIndices, 0, n - 1, result);
        return result;
    }

    private static void mergeSort(int[] arr, int[] indices, int[] temp, int[] tempIndices, int left, int right, int[] result) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, indices, temp, tempIndices, left, mid, result);
        mergeSort(arr, indices, temp, tempIndices, mid + 1, right, result);
        merge(arr, indices, temp, tempIndices, left, mid, right, result);
    }

    private static void merge(int[] arr, int[] indices, int[] temp, int[] tempIndices, int left, int mid, int right, int[] result) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[indices[i]] <= arr[indices[j]]) {
                result[indices[i]] += count;
                temp[k] = arr[indices[i]];
                tempIndices[k] = indices[i];
                k++;
                i++;
            } else {
                count++;
                temp[k] = arr[indices[j]];
                tempIndices[k] = indices[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            result[indices[i]] += count;
            temp[k] = arr[indices[i]];
            tempIndices[k] = indices[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = arr[indices[j]];
            tempIndices[k] = indices[j];
            k++;
            j++;
        }

        for (i = left; i <= right; i++) {
            arr[tempIndices[i]] = temp[i];
            indices[i] = tempIndices[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] result = countSmallerElements(arr);
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

}

