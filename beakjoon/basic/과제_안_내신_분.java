package algorithm.beakjoon.basic;
// 과제 안 내신 분..?
// https://www.acmicpc.net/problem/5597

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 과제_안_내신_분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean bool[] = new boolean[31];
        Arrays.fill(bool,true);
        for (int i=0; i<28; i++) {
            int num = Integer.parseInt(br.readLine());
            bool[num] = false;
        }

        for (int i=1; i<31; i++) {
            if (bool[i]) {
                System.out.println(i);
            }
        }
    }
}
