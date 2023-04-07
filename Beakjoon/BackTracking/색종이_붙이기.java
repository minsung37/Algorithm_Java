package algorithm.Beakjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기 {

    public static int[][] paper = new int[10][10];
    public static int[] paperCount;
    public static int result = Integer.MAX_VALUE;

    public static void backtracking(int x, int y, int count) {
        if (y >= 10) {
            result = Math.min(result, count);
            return;
        }
        if (x >= 10) {
            backtracking(0, y + 1, count);
            return;
        }
        // 종이 붙여야함
        if (paper[x][y] == 1) {
            for (int size = 1; size <= 5; size++) {
                // 이미 5개 다붙인경우
                if (paperCount[size] == 5)
                    continue;
                // 못붙이는 경우
                if (x + size - 1 >= 10 || y + size - 1 >= 10)
                    continue;
                // 붙일 수 있나 체크
                boolean nextStep = true;
                for (int nx = x; nx < x + size; nx++) {
                    for (int ny = y; ny < y + size; ny++) {
                        if (paper[nx][ny] == 0) {
                            nextStep = false;
                            break;
                        }
                    }
                    if (!nextStep)
                        break;
                }
                // 붙일수 있는 경우
                if (nextStep) {
                    for (int nx = x; nx < x + size; nx++)
                        for (int ny = y; ny < y + size; ny++)
                            paper[nx][ny] = 0;
                    paperCount[size]++;
                    backtracking(x + size, y, count + 1);
                    paperCount[size]--;
                    for (int nx = x; nx < x + size; nx++)
                        for (int ny = y; ny < y + size; ny++)
                            paper[nx][ny] = 1;
                }
            }
        } else {
            backtracking(x + 1, y, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paperCount = new int[6];
        backtracking(0, 0, 0);
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
