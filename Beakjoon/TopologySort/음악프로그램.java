package algorithm.Beakjoon.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음악프로그램 {

    public static int v, n;
    public static int[] indegree;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static ArrayList<Integer> result;

    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < v + 1; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int next : graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        indegree = new int[v + 1];
        graph = new ArrayList[v + 1];

        for (int i = 0; i < v + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 1; j < info.length - 1; j++) {
                int prev = Integer.parseInt(info[j]);
                int curr = Integer.parseInt(info[j + 1]);
                graph[prev].add(curr);
                indegree[curr]++;
            }
        }

        topologySort();
        if (result.size() != v) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i : result)
                sb.append(i).append("\n");
            System.out.println(sb);
        }
    }
}
