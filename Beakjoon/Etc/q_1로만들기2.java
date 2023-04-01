// https://www.acmicpc.net/problem/12852
package algorithm.Beakjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1로만들기2 {

    public static int n;
    public static int[] dp, result;

    public static void dynamicProgramming() {
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
    }

    public static void backTracking(int number, int depth) {
        if (number < 1)
            return;
        if (depth == dp[n]) {
            if (number == 1)
                print();
            return;
        }

        result[depth + 1] = number - 1;
        backTracking(number - 1, depth + 1);

        if (number % 2 == 0) {
            result[depth + 1] = number / 2;
            backTracking(number / 2, depth + 1);
        }

        if (number % 3 == 0) {
            result[depth + 1] = number / 3;
            backTracking(number / 3, depth + 1);
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        for (int i : result)
            sb.append(i).append(" ");
        System.out.println(sb);
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dynamicProgramming();
        // 최단거리 역추적
        result = new int[dp[n] + 1];
        result[0] = n;
        backTracking(n, 0);
    }
}
