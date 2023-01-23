package algorithm.beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
// 숨바꼭질3
// https://www.acmicpc.net/problem/13549

class Node{
    int where;
    int time;

    public Node(int where, int time) {
        this.where = where;
        this.time = time;
    }
}

public class 숨바꼭질3 {
    static int n, k;
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, -1);
        dp[n] = 0;

        if (n == k) {
            System.out.println(0);
            System.exit(0);
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n,0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.where * 2 < 100001) {
                if (current.time < dp[current.where * 2] || dp[current.where * 2] == -1) {
                    dp[current.where * 2] = current.time;
                    queue.addFirst(new Node(current.where * 2, current.time));
                }
            }
            if (current.where + 1 < 100001){
                if (current.time < dp[current.where + 1] || dp[current.where + 1] == -1){
                    dp[current.where + 1] = current.time + 1;
                    queue.addLast(new Node(current.where + 1, current.time + 1));
                }
            }
            if (current.where - 1 < 100001 && current.where - 1 >= 0) {
                if (current.time < dp[current.where - 1] || dp[current.where - 1] == -1){
                    dp[current.where - 1] = current.time + 1;
                    queue.addLast(new Node(current.where - 1, current.time + 1));
                }
            }
        }
        System.out.println(dp[k]);
    }
}

// 큐, 클래스 정의 사용
