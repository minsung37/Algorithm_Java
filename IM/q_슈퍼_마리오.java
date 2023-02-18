package algorithm.IM;

import java.util.Scanner;

public class q_슈퍼_마리오 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mushroom = new int[10];
        int sum = 0;
        int gap = 100;
        int score = 0;
        for (int i = 0; i < 10; i++)
            mushroom[i] = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            sum = sum + mushroom[i];
            // 최소 차이 일때의 값을 구한다.
            if (gap >= Math.abs(sum - 100)) {
                gap = Math.abs(sum - 100);
                score = sum;
            }
        }
        System.out.println(score);
    }
}
