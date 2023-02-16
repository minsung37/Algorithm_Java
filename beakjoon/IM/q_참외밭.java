package algorithm.beakjoon.IM;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class q_참외밭 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        // 밭정보 리스트와 큐에 저장
        Integer[] infoList = new Integer[6];
        Queue<Integer[]> infoQueue =  new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            Integer[] info = new Integer[2];
            info[0] = scanner.nextInt();
            info[1] = scanner.nextInt();
            infoList[i] = info[0];
            infoQueue.add(info);
        }
        // 회전수 구하기
        int rotate = 0;
        for(int i = 0; i < 6; i++) {
            if (infoList[i % 6].equals(infoList[(i + 2) % 6]) && infoList[(i + 1) % 6].equals(infoList[(i + 3) % 6])) {
                rotate = i;
                break;
            }
        }
        // 회전
        for (int i = 0; i < rotate; i++)
            infoQueue.add(infoQueue.poll());
        for (int i = 0; i < 6; i++)
            infoList[i] = Objects.requireNonNull(infoQueue.poll())[1];
        System.out.println((infoList[4] * infoList[5] - infoList[1] * infoList[2]) * size);
    }
}
