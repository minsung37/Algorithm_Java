package algorithm.Beakjoon.basic;
// 개수 세기
// https://www.acmicpc.net/problem/10807

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개수_세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int searchNum = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == searchNum) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
