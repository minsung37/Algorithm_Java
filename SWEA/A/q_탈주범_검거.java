package algorithm.SWEA.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_탈주범_검거 {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static final int 하 = 0, 좌 = 1, 상 = 2, 우 = 3;
    public static final int X = 0, Y = 1, TIME = 2;
    public static int[][] ground;
    public static int n, m, limit, result;
    public static boolean[][] visited;

    public static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {startX, startY, 0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Integer[] info = queue.poll();
            int x = info[X];
            int y = info[Y];
            int time = info[TIME];
            // 시간 초과
            if (time == limit)
                break;
            result++;
            for (int d = 0; d < 4; d++) {
                int nx = 0;
                int ny = 0;
                // 내가 있는 곳의 파이프 기준으로 방향 정하기
                if (ground[x][y] == 1) {
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 2) {
                    if (d == 좌 || d == 우)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 3) {
                    if (d == 상 || d == 하)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 4) {
                    if (d == 좌 || d == 하)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 5) {
                    if (d == 상 || d == 좌)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 6) {
                    if (d == 상 || d == 우)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                } else if (ground[x][y] == 7) {
                    if (d == 하 || d == 우)
                        continue;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                // 범위 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                // 이동 못하는 파이프인 경우
                if (d == 상)
                    if (ground[nx][ny] == 3 || ground[nx][ny] == 4 || ground[nx][ny] == 7)
                        continue;
                if (d == 하)
                    if (ground[nx][ny] == 3 || ground[nx][ny] == 5 || ground[nx][ny] == 6)
                        continue;
                if (d == 좌)
                    if (ground[nx][ny] == 2 || ground[nx][ny] == 6 || ground[nx][ny] == 7)
                        continue;
                if (d == 우)
                    if (ground[nx][ny] == 2 || ground[nx][ny] == 4 || ground[nx][ny] == 5)
                        continue;
                // 방문한 경우
                if (visited[nx][ny])
                    continue;
                // 파이프 아닌경우
                if (ground[nx][ny] == 0)
                    continue;
                queue.offer(new Integer[] {nx, ny, time + 1});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            ground = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    ground[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[n][m];
            result = 0;
            bfs(x, y);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
