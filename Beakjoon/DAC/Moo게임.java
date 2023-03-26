package algorithm.Beakjoon.DAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moo게임 {

    public static void dac(int len, int center, int n) {
        // 이전차수 moo문자열 길이
        int temp = (len - center) / 2;

        // n이 왼쪽
        if (n <= temp)
            dac(temp, center - 1, n);
            // n이 오른쪽
        else if (temp + center < n)
            dac(temp, center - 1, n - temp - center);
            // n이 center
        else
        if (temp + 1 == n)
            System.out.println("m");
        else
            System.out.println("o");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = 0, k = 0;
        while (len < n) {
            len = len + (k + 3) + len;
            k++;
        }
        // 전체길이, 센터길이, 찾을 위치
        dac(len, k + 2, n);
    }
}
