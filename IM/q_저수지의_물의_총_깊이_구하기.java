package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class q_저수지의_물의_총_깊이_구하기 {

    public static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 저수지 만들기
            int n = Integer.parseInt(br.readLine());
            int[][] reservoir = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    String info = st.nextToken();
                    if (info.equals("W"))
                        reservoir[i][j] = 1;
                }
            }
            // 최대 깊이 구하기
            int result = 0;
            int temp = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (reservoir[x][y] == 1) {
                        temp = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n)
                                temp = temp + reservoir[nx][ny];
                        }
                        result = Math.max(result, temp);
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}