package algorithm.Beakjoon.Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기2 {

    public static int n, m, k;
    public static int[][] ground;
    public static int[][][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = 1;
        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == n - 1 && y == m - 1)
                return visited[count][x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                // 벽을 만난 경우
                if (ground[nx][ny] == 1 && count < k && visited[count + 1][nx][ny] == 0) {
                    visited[count + 1][nx][ny] = visited[count][x][y] + 1;
                    queue.offer(new int[]{nx, ny, count + 1});
                }
                // 빈 칸을 만난 경우
                else if (ground[nx][ny] == 0 && visited[count][nx][ny] == 0) {
                    visited[count][nx][ny] = visited[count][x][y] + 1;
                    queue.offer(new int[]{nx, ny, count});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ground = new int[n][m];
        visited = new int[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                ground[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        bw.write(bfs() + "\n");
        bw.flush();
    }
}