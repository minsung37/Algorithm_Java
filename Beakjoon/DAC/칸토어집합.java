package algorithm.Beakjoon.DAC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 칸토어집합 {
    static char[] array;

    static void dac (int order, int left, int right) {
        if (order == 0)
            return;
        int partition = (right - left + 1) / 3;
        dac(order - 1, left, left + partition - 1);
        for (int i = left + partition; i < left + 2 * partition; i++)
            array[i] = ' ';
        dac(order - 1, left + 2 * partition, right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        while (true) {
            sb = new StringBuilder();
            try {
                int n = Integer.parseInt(br.readLine());
                int len = (int) Math.pow(3, n);
                array = new char[len];
                for (int i = 0; i < len; i++)
                    array[i] = '-';
                dac(n, 0, len - 1);
                for (char c : array)
                    sb.append(c);
                System.out.println(sb);
            } catch (Exception e) {
                System.exit(0);
            }
        }
    }
}
