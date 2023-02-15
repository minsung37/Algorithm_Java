package algorithm.beakjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class q2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean graph[][] = new boolean[100][100];
        int k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    graph[i][j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j])
                    result++;
            }
        }
        System.out.println(result);
    }
}