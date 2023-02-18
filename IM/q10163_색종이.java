package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10163_색종이 {
	public static void main(String[] args) throws IOException {
		final int size = 1002;
		int[][] paper = new int[size][size];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] result = new int[n + 1];
		// 종이 배치
		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			for (int p = x; p < x + dx; p++) {
				for (int q = y; q < y + dy; q++) {
					paper[p][q] = i;
				}
			}
		}
		// 종이 넓이구하기
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (paper[i][j] > 0)
					result[paper[i][j]]++;

		for (int i = 1; i < n + 1; i++)
			System.out.println(result[i]);
	}
}
