package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_색종이_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] squre = new int[102][102];
        int n = scanner.nextInt();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 색종이 입력 받기
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    squre[x + j][y + k] = 1;
        }

        // 둘레구하기
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int zeroCount = 0;
                if (squre[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (i + dx[k] < 0 || j + dy[k] < 0)
                            continue;
                        if (squre[i + dx[k]][j + dy[k]] == 0) {
                            zeroCount++;
                        }
                    }
                }
                if (zeroCount > 0)
                    result++;
                // 바깥 모서리
                if (zeroCount == 2)
                    result++;
            }
        }
        System.out.println(result);
    }
}
