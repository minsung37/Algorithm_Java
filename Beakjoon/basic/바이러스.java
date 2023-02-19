package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n + 1];
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            visited[x] = true;
            for (int i = 1; i < n + 1; i++)
                if (!visited[i] && graph[x][i] == 1)
                    queue.offer(i);

        }

        int count = 0;
        for (Boolean isVirus : visited)
            if (isVirus)
                count++;
        System.out.println(count - 1);
    }
}
