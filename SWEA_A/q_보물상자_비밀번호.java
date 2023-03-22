package algorithm.SWEA_A;

import java.util.Scanner;

public class q_보물상자_비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (m % 2 == 1)
                    count++;
                m = m / 2;
            }
            if (count == n) {
                System.out.printf("#%d ON\n", t + 1);
            } else {
                System.out.printf("#%d OFF\n", t + 1);
            }
        }
    }
}
