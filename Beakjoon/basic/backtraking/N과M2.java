package algorithm.Beakjoon.basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {

    public static int n;
    public static int m;
    public static int[] array;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void backTracking(int prev, int depth) {
        if (depth == m) {
            for (int val : array) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = prev; i <= n; i++) {
            array[depth] = i;
            backTracking(i,depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        array = new int[m];
        backTracking(1, 0);
        System.out.println(sb);
    }
}
