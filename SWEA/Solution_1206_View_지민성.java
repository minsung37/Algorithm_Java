package algorithm.SWEA;

import java.util.Scanner;

public class Solution_1206_View_지민성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++)
				nums[i] = sc.nextInt();
			
			// 2번째 건물 부터 n - 2 까지 조망권 있는 세대수 구하기
			int result = 0;
			for (int i = 2; i < n - 2; i++) {
				int one = nums[i - 2];
				int two = nums[i - 1];
				int curr = nums[i];
				int four = nums[i + 1];
				int five = nums[i + 2];
				
				// 조망권 없으면 패스
				if (one > curr || two > curr || four > curr || five > curr)
					continue;
				
				// 세대수 계산
				int height = curr - Math.max(Math.max(one, two), Math.max(four, five));
				result = result + height;
			}
			System.out.println("#" + (t + 1) + " " + result);
		}
	}
}
