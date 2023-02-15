package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_딱지놀이 {
    public static void main(String[] args) {
        // 별 - 4, 동그라미 - 3, 네모 - 2, 세모 - 1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int[] aScore = {0, 0, 0, 0, 0};
            int[] bScore = {0, 0, 0, 0, 0};
            boolean isDraw = true;
            int aCount = scanner.nextInt();
            for (int j = 0; j < aCount; j++)
                aScore[scanner.nextInt()]++;

            int bCount = scanner.nextInt();
            for (int j = 0; j < bCount; j++)
                bScore[scanner.nextInt()]++;

            for (int j = 4; j >= 0 ; j--) {
                if (aScore[j] > bScore[j]) {
                    System.out.println("A");
                    isDraw = false;
                    break;
                } else if (aScore[j] < bScore[j]) {
                    System.out.println("B");
                    isDraw = false;
                    break;
                }
            }
            if (isDraw) {
                System.out.println("D");
            }
        }
    }
}
