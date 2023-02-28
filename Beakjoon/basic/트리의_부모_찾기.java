package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리의_부모_찾기 {

    public static Map<Integer, List<Integer>> tree;
    public static int n;
    public static boolean[] visited;
    public static int[] result;

    public static void dfs(int v) {
        visited[v] = true;
        List<Integer> temp = tree.get(v);
        for (int i : temp) {
            if (!visited[i]){
                result[i] = v;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new HashMap<Integer, List<Integer>>();
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        result = new int[n + 1];
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            List <Integer> temp1 = tree.get(first);
            List <Integer> temp2 = tree.get(second);
            temp1.add(second);
            temp2.add(first);
            tree.put(first, temp1);
            tree.put(second, temp2);
        }
        dfs(1);
        for (int i = 2; i < n + 1; i++)
            System.out.print(result[i] + " ");
    }
}
