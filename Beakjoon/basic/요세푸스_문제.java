package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            queue.offer(i);

        System.out.print("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++)
                queue.offer(queue.poll());
            if (queue.size() == 1) {
                System.out.print(queue.poll());
                break;
            }
            System.out.printf("%d, ", queue.poll());
        }
        System.out.println(">");
    }
}