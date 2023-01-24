package algorithm.beakjoon.advanced;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 드래곤 커브
// https://www.acmicpc.net/problem/15685

public class 드래곤_커브 {
    public static void main(String[] args) throws IOException {
        int size = 101;
        boolean[][] graph = new boolean[size][size];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> d_list = new ArrayList<>();
            d_list.add(d);
            graph[x][y] = true;

            for (int j = 1; j <= g; j++)
                for (int k = d_list.size() - 1; k >= 0; k--)
                    d_list.add((d_list.get(k) + 1) % 4);

            for (Integer direction : d_list) {
                x = x + dx[direction];
                y = y + dy[direction];
                graph[x][y] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1; j++)
                if (graph[i][j] && graph[i + 1][j] && graph[i][j + 1] && graph[i + 1][j + 1])
                    result++;
        System.out.println(result);
    }
}
