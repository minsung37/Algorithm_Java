package algorithm.SWEA.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_홈_방범_서비스 {

    public static int n, m, result;
    public static int[][] map;

    public static int homeSecurityService(int x, int y) {
        int temp1 = 0;
        for (int c = 0; c < 21; c++) {
            int invest = c * c + (c + 1) * (c + 1);
            int count = 0;
            int temp2 = 0;
            for (int row = x - c; row <= x + c; row++) {
                for (int col = y - c; col <= y + c; col++){
                    if (row < 0 || row >= n || col < 0 || col >= n)
                        continue;
                    if (Math.abs(x - row) + Math.abs(y - col) <= c) {
                        if (map[row][col] != 0) {
                            invest = invest - map[row][col] * m;
                            count++;
                        }
                    }
                }
            }
            if (invest <= 0) {
                temp1 = Math.max(temp2, count);
            }
        }
        return temp1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    result = Math.max(result, homeSecurityService(i, j));
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
