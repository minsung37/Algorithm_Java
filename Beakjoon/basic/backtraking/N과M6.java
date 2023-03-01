package algorithm.Beakjoon.basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M6 {
    public static int n;
    public static int m;
    public static int[] array;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void backTracking(int prev, int depth) {
        if (depth == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(array[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = prev; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i + 1,depth - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
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
        visited = new boolean[n];
        backTracking(0, m);
        System.out.println(sb);
    }
}
