package algorithm.Beakjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M7_중복순열 {

    public static int n, m;
    public static int[] array, number;
    public static StringBuilder sb;

    public static void print() {
        for (int val : array)
            sb.append(val).append(" ");
        sb.append("\n");
    }

    public static void 중복순열(int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            array[depth] = number[i];
            중복순열(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++)
            number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        array = new int[m];
        sb = new StringBuilder();
        중복순열(0);
        System.out.println(sb.toString());
    }
}
