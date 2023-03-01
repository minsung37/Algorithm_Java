package algorithm.Beakjoon.basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의_합 {

    public static int count;
    public static int n, s;
    public static int[] numbers;

    public static void backtraking(int index, int sum) {
        if (index == n) {
            if (sum == s)
                count++;
            return;
        }
        backtraking(index + 1, sum);
        backtraking(index + 1, sum + numbers[index]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        count = 0;
        backtraking(0,0);
        if (s == 0)
            count--;
        System.out.println(count);
    }
}