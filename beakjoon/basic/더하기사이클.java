package algorithm.beakjoon.basic;
import java.io.*;
// 더하기 사이클
// https://www.acmicpc.net/problem/1110


public class 더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int tempNumber = number;
        int count = 0;
        while (true) {
            if (tempNumber / 10 == 0) {
                tempNumber = tempNumber * 10 + tempNumber;
            } else {
                int temp = tempNumber / 10 + tempNumber % 10;
                tempNumber = (tempNumber % 10) * 10 + temp % 10;
            }
            count++;
            if (tempNumber == number)
                break;
        }
        System.out.println(count);
    }
}

// BufferedReader 공부
