// 설탕배달2
// https://www.acmicpc.net/problem/26099
package algorithm.Beakjoon.Etc;

import java.util.Scanner;

public class q_설탕배달2 {
    public static void main(String[] args) {
        // 갈색 3 은색 5
        Scanner sc = new Scanner(System.in);
        long cost = sc.nextLong();
        // 9로 전부낸다고 생각
        long nine = cost / 5;
        long seven = 0;
        // 9로 전부 냈을때 나머지 돈 계산
        long mod = cost % 5;
        // 이때 나머지가 없으면 낼 수 있는 상태이다.
        if (cost == 0) {
            System.out.println(nine);
            System.exit(0);
        }
        boolean possible = false;
        // 9원을 하나씩 더해가면서 낼수 있는지 검사
        for (int i = 0; i < nine + 1; i++) {
            long modPlusNine = mod + 5 * i;
            // 이때 돈을 낼수 있다.
            if (modPlusNine % 3 == 0) {
                nine = nine - i;
                seven = modPlusNine / 3;
                possible = true;
                break;
            }
        }
        if (possible) {
            // 낼수 있는 경우
            System.out.println(nine + seven);
        } else {
            // 못내는 경우
            System.out.println(-1);
        }
    }
}
