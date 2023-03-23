package algorithm.Beakjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class 비숍 {

    public static int n, repeat, whiteRepeat, blackRepeat, result, whiteResult, blackResult;
    public static int[][] chess;
    public static List<Integer> bishopList, whiteBishopList, blackBishopList;
    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {-1, 1, -1, 1};
    public static boolean isBlack;

    public static void solution() {
        if (isBlack) {
            repeat = whiteRepeat;
            result = whiteResult;
            bishopList = whiteBishopList;
        } else {
            repeat = blackRepeat;
            result = blackResult;
            bishopList = blackBishopList;
        }
        backTracking(0,0);
    }

    public static void backTracking(int depth, int count) {
        if (depth == repeat) {
            if (isBlack)
                blackResult = Math.max(blackResult, count);
            else
                whiteResult = Math.max(whiteResult, count);
            return;
        }
        // 비숍 공격범위 표시숫자
        int check = depth + 2;
        int bishop = bishopList.get(depth);
        int x = bishop / n;
        int y = bishop % n;
        boolean isBishop = true;
        // 비숍둘수 있는지판단
        outer : for (int d = 0; d < 4; d++) {
            int r = 1;
            while (true) {
                int nx = x + r * dx[d];
                int ny = y + r * dy[d];
                // 체스판 크기 벗어나는 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    break;
                if (chess[nx][ny] > 1) {
                    isBishop = false;
                    break outer;
                }
                r++;
            }
        }
        // 비숍두기
        if (isBishop) {
            chess[x][y] = check;
            backTracking(depth + 1, count + 1);
            chess[x][y] = 1;
        }
        // 안두는 경우
        backTracking(depth + 1, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // white, black 비숍 입력 받고 개수 구하기
        n = Integer.parseInt(br.readLine());
        chess = new int[n][n];
        whiteBishopList = new ArrayList<>();
        blackBishopList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                chess[i][j] = k;
                if (k == 1)
                    if ((i + j) % 2 == 0)
                        whiteBishopList.add(i * n + j);
                    else
                        blackBishopList.add(i * n + j);
            }
        }
        whiteRepeat = whiteBishopList.size();
        blackRepeat = blackBishopList.size();
        // whiteBishop
        solution();
        // blackBishop
        isBlack = true;
        solution();
        System.out.println(blackResult + whiteResult);
    }
}