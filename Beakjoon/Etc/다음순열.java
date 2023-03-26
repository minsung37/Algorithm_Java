package algorithm.Beakjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다음순열 {

    public static int n;
    public static int[] array;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
    }

    public static void nextPermutation() {
        // 1. 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인(a)
        int a = n - 2;
        while (a >= 0 && array[a] >= array[a + 1])
            a--;

        // (사전순 마지막인 경우 -1)
        if (a <= -1) {
            System.out.println(-1);
            System.exit(0);
        }

        // 2. 다시 뒤에서부터 탐색하면서 a보다 큰 첫번째 인덱스를 확인(b)
        if (a != -1) {
            int b = array.length - 1;
            while (array[a] >= array[b])
                b--;
            swap(array, a, b);
        }

        // 3. a + 1에서 부터 끝까지 오름차순 정렬
        int start = a + 1;
        int end = array.length - 1;
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) throws IOException {
        init();
        nextPermutation();
        for (int i : array)
            System.out.printf("%d ", i);
    }
}
