package algorithm.Beakjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용_구하기2 {

    public static final int INF = Integer.MAX_VALUE, 번호 = 0, 거리 = 1;
    public static int n, m;
    public static List<int[]>[] graph;
    public static int[] distance;
    public static List<Integer>[] path;

    public static void dijkstra(int start) {

        PriorityQueue<int[]> heapq = new PriorityQueue<>(Comparator.comparingInt(o -> o[거리]));
        heapq.offer(new int[] {start, 0});
        distance[start] = 0;
        path[start].add(start);
        while (!heapq.isEmpty()) {
            int[] info = heapq.poll();
            int dist = info[거리];
            int curr = info[번호];
            // 목적지의 최단 거리보다 현재노드의 거리가 큰경우
            if (distance[curr] < dist)
                continue;
            // 현재노드와 인접한 다른 노드들을 확인
            for (int[] node : graph[curr]) {
                int nextDistance = dist + node[거리];
                // 현재 노드를 거쳐서 다른 노드로 가는 값이 더 작을때 갱신
                if (nextDistance < distance[node[번호]]) {
                    distance[node[번호]] = nextDistance;
                    path[node[번호]].clear();
                    for (int i: path[curr])
                        path[node[번호]].add(i);
                    path[node[번호]].add(node[번호]);
                    heapq.offer(new int[] {node[번호], nextDistance});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 인접리스트, 최단거리 테이블 만들기
        graph = new ArrayList[n + 1];
        path = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
        }
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(distance[end]);
        System.out.println(path[end].size());
        for (int i : path[end])
            System.out.printf("%d ", i);
    }
}
