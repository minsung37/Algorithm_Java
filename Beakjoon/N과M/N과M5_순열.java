package algorithm.Beakjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5_순열 {
    public static int n, m;
    public static int[] number, array;
    public static StringBuilder sb;
    public static boolean[] visited;

    public static void print() {
        for (int val : array)
            sb.append(val).append(" ");
        sb.append("\n");
    }

    public static void permutation(int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = number[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++)
            number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        array = new int[m];
        visited = new boolean[n];
        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb.toString());
    }
}
