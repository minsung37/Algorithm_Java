package algorithm.beakjoon.basic;
// 합
// https://www.acmicpc.net/problem/8393

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
