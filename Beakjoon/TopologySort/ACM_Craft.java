package algorithm.Beakjoon.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACM_Craft {

    public static int n, k, result;
    public static int[] timeTable, indegree, dp;
    public static List<Integer>[] graph;

    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = timeTable[i];
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                // 현재노드에서 다음 노드로 진입가능 할때 dp 테이블 갱신
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[curr] + timeTable[next]);
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            timeTable = new int[n + 1];
            indegree = new int[n + 1];
            dp = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++)
                timeTable[i] = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int curr = Integer.parseInt(st.nextToken());
                indegree[curr]++;
                graph[prev].add(curr);
            }

            int target = Integer.parseInt(br.readLine());
            result = 0;
            topologySort();
            System.out.println(dp[target]);
        }
    }
}
