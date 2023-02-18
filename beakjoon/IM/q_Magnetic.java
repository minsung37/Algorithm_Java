package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_Magnetic {
    public static void main(String[] args) {
        final int size = 100;
        Scanner scanner = new Scanner(System.in);
        int[][] squre = new int[size][size];
        for (int t = 0; t < 10; t++) {
            // 입력받기
            int a = scanner.nextInt();
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    squre[i][j] = scanner.nextInt();
            // 교착상태 찾기
            int result = 0;
            for (int i = 0; i < size; i++) {
                boolean findN = false;
                for (int j = 0; j < size; j++) {
                    if (!findN && squre[j][i] == 1)
                        findN = true;
                    if (findN && squre[j][i] == 2){
                        result++;
                        findN = false;
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
