package algorithm.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_준환이의_양팔저울 {

    public static int n, result;
    public static int[] weightList, array;
    public static boolean[] visited;

    public static void permutaion(int depth) {
        if (depth == n)
            powerSet(0,0,0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = weightList[i];
                permutaion(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void powerSet(int depth, int left, int right) {
        if (left < right)
            return;
        if (depth == n) {
            result++;
            return;
        }
        powerSet(depth + 1, left + array[depth], right);
        powerSet(depth + 1, left,right + array[depth]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 문제입력받기
            n = Integer.parseInt(br.readLine());
            weightList = new int[n];
            array = new int[n];
            visited = new boolean[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                weightList[i] = Integer.parseInt(st.nextToken());
            // 초기화
            result = 0;
            permutaion(0);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
