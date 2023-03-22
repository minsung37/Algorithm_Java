package algorithm.SWEA_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q_요리사 {

    public static int n;
    public static int[][] comb;
    public static boolean[] visited;
    public static int result;

    public static void backTracking(int depth, int index) {
        if (depth == n / 2) {
            result = Math.min(result, tasteDifference(visited));
            return;
        }
        for (int i = index; i < n; i++) {
            visited[i] = true;
            backTracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int tasteDifference(boolean[] visited) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                first.add(i);
            } else {
                second.add(i);
            }
        }
        return Math.abs(cook(first) - cook(second));
    }

    public static int cook(List<Integer> food) {
        int value = 0;
        for (int i = 0; i < n / 2 - 1; i++)
            for (int j = i + 1; j < n / 2; j++)
                value = value + comb[food.get(i)][food.get(j)] + comb[food.get(j)][food.get(i)];
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            comb = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    comb[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[n];
            result = Integer.MAX_VALUE;
            backTracking(0, 0);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
