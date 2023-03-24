package algorithm.Beakjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2_조합 {

    public static int n, m;
    public static int[] array;
    public static StringBuilder sb;

    public static void print() {
        for (int val : array)
            sb.append(val).append(" ");
        sb.append("\n");
    }

    public static void combination(int depth, int index) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = index; i < n; i++) {
            array[depth] = i + 1;
            combination(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        sb = new StringBuilder();
        combination(0,0);
        System.out.println(sb.toString());
    }
}
