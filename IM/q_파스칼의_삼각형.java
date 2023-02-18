package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_파스칼의_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[11][11];
        dp[0][0] = 1;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + (t + 1));
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}