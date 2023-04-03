package algorithm.Beakjoon.TopologySort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {

    public static int n, m;
    public static int[] indegree;
    public static List<Integer>[] graph;
    public static StringBuilder sb;

    public static void topologySort() {
        // 진입차수가 0인 노드를 큐에 삽입
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // 위상정렬
        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");
            for (int i : graph[v]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        // 이전차수, 연결리스트 만들기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }
        topologySort();
        System.out.println(sb);
    }
}