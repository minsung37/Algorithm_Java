package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 평균
// https://www.acmicpc.net/problem/1546


public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] scores = new double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        double result = 0;
        Arrays.sort(scores);

        for (double score: scores) {
            result = result + (score / scores[n - 1] * 100);
        }

        System.out.println(result / n);
    }
}
