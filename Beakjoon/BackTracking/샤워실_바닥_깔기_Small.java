package algorithm.Beakjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 샤워실_바닥_깔기_Small {

    public static int[][] floor, dx, dy;
    public static int k, n, m, size, count, number;
    public static boolean isTiling;

    public static void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", floor[i][j]);
            }
            System.out.println();
        }
    }

    public static void tiling(int x, int y, int d, int number) {
        for (int k = 0; k < 3; k++) {
            int nx = x + dx[d][k];
            int ny = y + dy[d][k];
            floor[nx][ny] = number;
        }
    }

    public static void backTracking(int depth) {
        // 모든 타일 깐경우 출력하고 종료
        if (depth == count) {
            print();
            System.exit(0);
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                // 0이면 깔수 있음
                if (floor[x][y] == 0) {
                    for (int d = 0; d < 4; d++) {
                        isTiling = true;
                        for (int k = 0; k < 3; k++) {
                            int nx = x + dx[d][k];
                            int ny = y + dy[d][k];
                            // 벗어나면 타일 못깜
                            if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                                isTiling = false;
                                break;
                            }
                            // 이미 깔려있는 경우 타일 못깜
                            if (floor[nx][ny] != 0) {
                                isTiling = false;
                                break;
                            }
                        }
                        if (!isTiling)
                            continue;
                        // 타일 깔수 있는경우 backTracking
                        tiling(x, y, d, number);
                        number++;
                        backTracking(depth + 1);
                        tiling(x, y, d, 0);
                        number--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, k);
        floor = new int[size][size];
        floor[size - m][n - 1] = -1;
        dx = new int[][] {{0, 0, 1}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}};
        dy = new int[][] {{0, 1, 0}, {0, 0, -1}, {0, 0, -1}, {0, 1, 0}};
        count = (size * size - 1) / 3;
        number = 1;
        backTracking(0);
    }
}
