package algorithm.SWEA.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q_벽돌깨기 {

    public static int n, w, h, result;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void backTracking(int depth, int[][] board) {
        if (depth == n) {
            result = Math.min(result, brickCount(board));
            return;
        }

        for (int i = 0; i < w; i++) {
            int[][] copyBoard = deepcopy(board);
            backTracking(depth + 1, dropBallBfs(i, copyBoard));
        }
    }

    public static int[][] dropBallBfs(int spot, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for (int xIndex = 0; xIndex < h; xIndex++) {
            if (board[xIndex][spot] != 0) {
                queue.offer(new int[] {xIndex, spot, board[xIndex][spot]});
                board[xIndex][spot] = 0;
                break;
            }
        }
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int size = info[2];
            for (int d = 0; d < 4; d++) {
                for (int s = 0; s < size - 1; s++) {
                    int nx = x + dx[d] * (s + 1);
                    int ny = y + dy[d] * (s + 1);
                    // 범위 벗어나는 경우
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue;
                    // 0이 적혀있는 경우
                    if (board[nx][ny] == 0)
                        continue;
                    queue.offer(new int[] {nx, ny, board[nx][ny]});
                    board[nx][ny] = 0;
                }
            }
        }
        for (int y = 0; y < w; y++) {
            Stack<Integer> stack = new Stack<>();
            for (int x = 0; x < h; x++) {
                if (board[x][y] != 0) {
                    stack.push(board[x][y]);
                    board[x][y] = 0;
                }
            }
            if (stack.isEmpty())
                continue;
            for (int x = h - 1; x >= 0; x--) {
                board[x][y] = stack.pop();
                if (stack.isEmpty())
                    break;
            }
        }

        return board;
    }

    public static int brickCount(int[][] board) {
        int brokenBrick = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (board[i][j] != 0)
                    brokenBrick++;
        return brokenBrick;
    }

    public static int[][] deepcopy(int[][] board) {
        int[][] copyBoard = new int[h][w];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                copyBoard[i][j] = board[i][j];
        return copyBoard;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[][] originBoard = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    originBoard[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = Integer.MAX_VALUE;
            backTracking(0, originBoard);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
