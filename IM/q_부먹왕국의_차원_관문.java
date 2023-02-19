package algorithm.IM;

import java.util.Scanner;

public class q_부먹왕국의_차원_관문 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int[] city = new int[scanner.nextInt()];
            int distance = scanner.nextInt();
            for (int i = 0; i < city.length; i++)
                city[i] = scanner.nextInt();

            int result = 0, temp = 0;
            for (int i = 0; i < city.length; i++) {
                temp++;
                // 관문 만나거나, 거리차이 벌어진경우
                if (city[i] == 1 || temp >= distance) {
                    // 거리차이 나고 관문없으면 설치
                    if (temp >= distance && city[i] != 1)
                        result = result + 1;
                    temp = 0;
                }
            }
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
