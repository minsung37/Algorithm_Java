package algorithm.Beakjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q_행성터널 {

    public static int[] parent;
    public static int n;
    public static int[][] x, y, z;

    public static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static Integer distance(int[][] curr, int i) {
        return Math.abs(curr[i][0] - curr[i + 1][0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        x = new int[n][2];
        y = new int[n][2];
        z = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent[i] = i;
            x[i] = new int[] {Integer.parseInt(st.nextToken()), i};
            y[i] = new int[] {Integer.parseInt(st.nextToken()), i};
            z[i] = new int[] {Integer.parseInt(st.nextToken()), i};
        }
        Arrays.sort(x, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(y, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(z, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int i = 0; i < n - 1; i++) {
            heap.offer(new Integer[] {distance(x, i), x[i][1], x[i + 1][1]});
            heap.offer(new Integer[] {distance(y, i), y[i][1], y[i + 1][1]});
            heap.offer(new Integer[] {distance(z, i), z[i][1], z[i + 1][1]});
        }

        int result = 0, count = n -1;
        while (count != 0) {
            Integer[] info = heap.poll();
            int cost = info[0];
            int i = info[1];
            int j = info[2];
            if (find(i) != find(j)) {
                union(i, j);
                result = result + cost;
                count--;
            }
        }
        System.out.println(result);
    }
}
