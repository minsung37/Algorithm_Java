package algorithm.Beakjoon.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 계보_복원가_호석 {

    public static int n;
    public static int[] indegree;
    public static List<String> root;
    public static List<Integer>[] graph;
    public static List<String>[] family;
    public static Map<String, Integer> mapStoI;
    public static Map<Integer, String> mapItoS;


    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        root = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                root.add(mapItoS.get(i));
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    family[curr].add(mapItoS.get(next));
                    for (String root : family[next])
                        family[curr].add(root);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        Arrays.sort(info);

        indegree = new int[n];

        mapStoI = new HashMap<>();
        mapItoS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapStoI.put(info[i], i);
            mapItoS.put(i, info[i]);
        }

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        family = new ArrayList[n];
        for (int i = 0; i < n; i++)
            family[i] = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            int c = mapStoI.get(child);
            int p = mapStoI.get(parent);
            indegree[c]++;
            graph[p].add(c);
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        sb.append(root.size()).append("\n");
        for (String i: root)
            sb.append(i).append(" ");
        for (int i = 0; i < n; i++) {
            sb.append("\n");
            sb.append(mapItoS.get(i)).append(" ");
            sb.append(family[i].size()).append(" ");
            List<String> temp = family[i];
            Collections.sort(temp);
            for (String name : temp)
                sb.append(name).append(" ");
        }
        System.out.println(sb);
    }
}
