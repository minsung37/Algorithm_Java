package algorithm.SWEA_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_보호필름 {

    public static int d, w, k, result;
    public static int[][] film;

    // 성능검사
    public static boolean test() {
        for (int i = 0; i < w; i++) {
            int tempCount = 1;
            int count = 0;
            int prev = (film[0][i]) % 2;
            for (int j = 0; j < d - 1; j++) {
                if ((film[j][i]) % 2 == (film[j + 1][i]) % 2) {
                    if ((film[j + 1][i]) % 2 == prev) {
                        tempCount++;
                        continue;
                    }
                }
                count = Math.max(count, tempCount);
                prev = (film[j + 1][i]) % 2;
                tempCount = 1;
            }
            count = Math.max(count, tempCount);
            if (count < k)
                return false;
        }
        return true;
    }

    public static void backTracking(int depth, int index) {
        // 굳이 탐색하지 않아도 되는 경우
        if (result < depth)
            return;
        if (depth > k)
            return;
        // base
        if (test()) {
            result = Math.min(result, depth);
            return;
        }
        // combination
        for (int i = index; i < d; i++) {
            // A필름(2로나눈 나머지 0) 만들기
            for (int j = 0; j < w; j++)
                if (film[i][j] == 1)
                    film[i][j] = 2;
            backTracking(depth + 1, i + 1);
            // 다시 되돌리기
            for (int j = 0; j < w; j++)
                if (film[i][j] == 2)
                    film[i][j] = 1;

            // B필름(2로나눈 나머지 1) 만들기
            for (int j = 0; j < w; j++)
                if (film[i][j] == 0)
                    film[i][j] = 3;
            backTracking(depth + 1, i + 1);
            // 다시 되돌리기
            for (int j = 0; j < w; j++)
                if (film[i][j] == 3)
                    film[i][j] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            film = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = Integer.MAX_VALUE;
            backTracking(0,0);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
