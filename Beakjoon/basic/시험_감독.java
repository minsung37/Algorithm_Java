package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 시험 감독
// https://www.acmicpc.net/problem/13458


public class 시험_감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rooms[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        double b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        double count = 0;
        for (double room: rooms) {
            room = room - b;
            count++;
            if (room > 0)
                count = count + Math.ceil(room / c);
        }
        System.out.println((long)count);
    }
}

// 올림, 자료형 공부
