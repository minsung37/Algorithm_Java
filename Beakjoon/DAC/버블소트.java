package algorithm.Beakjoon.DAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트 {

    public static int[] sortedArr;
    public static long swapCount;

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int L = left;
        int R = mid + 1;
        int index = left;
        while (L <= mid && R <= right) {
            if (arr[L] <= arr[R]) {
                sortedArr[index++] = arr[L++];
            } else {
                swapCount = swapCount + (mid - L) + 1;
                sortedArr[index++] = arr[R++];
            }
        }

        if (L <= mid)
            for (int i = L; i <= mid; i++)
                sortedArr[index++] = arr[i];
        else
            for (int i = R; i <= right; i++)
                sortedArr[index++] = arr[i];

        for (int i = left; i <= right; i++)
            arr[i] = sortedArr[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        sortedArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        swapCount = 0;
        mergeSort(arr, 0, n - 1);
        System.out.println(swapCount);
    }
}
