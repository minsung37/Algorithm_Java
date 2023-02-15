package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_설탕배달 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 3) {
            System.out.println(1);
            System.exit(0);
        } else if (n == 4) {
            System.out.println(-1);
            System.exit(0);
        }

        int[] dp = new int[n + 1];
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 6; i < n + 1; i++) {
            if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            } else if (dp[i - 3] != 0) {
                dp[i] = dp[i - 3] + 1;
            } else if (dp[i - 5] != 0) {
                dp[i] = dp[i - 5] + 1;
            }
        }
        if (dp[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
