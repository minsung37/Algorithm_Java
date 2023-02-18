package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_수의_새로운_연산 {

    public static final int size = 300;
    public static int[] dp = new int[size];
    public static int[] coordinate = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 1; i < size; i++){
            sum = sum + i;
            dp[i] = sum;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinate[0] = 0;
            coordinate[1] = 0;
            numToCoordinate(x);
            numToCoordinate(y);
            int line = coordinate[0] + coordinate[1];
            int result = dp[line - 1] - (line - coordinate[0] - 1);
            System.out.println("#" + (t + 1) + " " + result);
        }
    }

    public static void numToCoordinate(int num) {
        int x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            if (dp[i] == num) {
                x = i;
                y = 1;
                break;
            }
            if (dp[i] > num) {
                int offSet = dp[i] - num;
                x = i - offSet;
                y = 1 + offSet;
                break;
            }
        }
        coordinate[0] = coordinate[0] + x;
        coordinate[1] = coordinate[1] + y;
    }
}