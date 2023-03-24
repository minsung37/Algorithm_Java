package algorithm.Beakjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M12_중복조합 {

    public static int n, m;
    public static int[] array, number;
    public static StringBuilder sb;
    public static Set<Integer> deduplication;
    public static int primeNumber = 13;

    public static void print() {
        for (int val : array)
            sb.append(val).append(" ");
        sb.append("\n");
    }

    public static void 중복조합(int depth, int index, int sum) {
        if (depth == m) {
            if (!deduplication.contains(sum)) {
                deduplication.add(sum);
                print();
            }
            return;
        }

        for (int i = index; i < n; i++) {
            array[depth] = number[i];
            중복조합(depth + 1, i, sum * primeNumber + number[i]);
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
        deduplication = new HashSet<>();
        중복조합(0,0, 0);
        System.out.println(sb.toString());
    }
}
