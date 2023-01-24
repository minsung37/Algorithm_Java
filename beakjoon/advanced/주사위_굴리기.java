package algorithm.beakjoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        int[][] graph = new int[n][m];
        int[] direction = new int[k];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            direction[i] = Integer.parseInt(st.nextToken());

        int[] dice = {0, 0, 0, 0, 0, 0};

        for (int d : direction) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                int temp = dice[0];
                switch(d) {
                    case 1:
                        dice[0] = dice[3];
                        dice[3] = dice[5];
                        dice[5] = dice[2];
                        dice[2] = temp;
                        break;
                    case 2:
                        dice[0] = dice[2];
                        dice[2] = dice[5];
                        dice[5] = dice[3];
                        dice[3] = temp;
                        break;
                    case 3:
                        dice[0] = dice[4];
                        dice[4] = dice[5];
                        dice[5] = dice[1];
                        dice[1] = temp;
                        break;
                    case 4:
                        dice[0] = dice[1];
                        dice[1] = dice[5];
                        dice[5] = dice[4];
                        dice[4] = temp;
                        break;
                }
                x = nx;
                y = ny;
                System.out.println(dice[0]);
                if (graph[x][y] == 0) {
                    graph[x][y] = dice[5];
                } else {
                    dice[5] = graph[x][y];
                    graph[x][y] = 0;
                }
            }
        }
    }
}
