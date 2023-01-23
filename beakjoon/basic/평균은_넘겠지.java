package algorithm.beakjoon.basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 평균은 넘겠지
// https://www.acmicpc.net/problem/4344


public class 평균은_넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            double sum = Arrays.stream(arr).sum();
            double avg = sum / N;

            double count = 0;

            for (int score : arr) {
                if (score > avg) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", (count / N) * 100);
        }
    }
}

// 한줄에 배열의 크기와 값들이 주어질때 StringTokenizer로 받는.
// 정해진형식으로 출력