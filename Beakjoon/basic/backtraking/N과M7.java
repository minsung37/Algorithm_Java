package algorithm.Beakjoon.basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M7 {
    public static int n;
    public static int m;
    public static int[] array;
    public static StringBuilder sb;
    public static int[] permutation;

    public static void backTracking(int depth) {
        if (depth == 0) {
            for (int i = m - 1; i >= 0; i--)
                sb.append(permutation[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            permutation[depth - 1] = array[i];
            backTracking(depth - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        // 문제입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);

        permutation = new int[m];
        backTracking(m);
        System.out.println(sb);
    }
}