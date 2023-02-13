package algorithm.SWEA;

import java.util.Scanner;

public class Solution_2068_최대수구하기_지민성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int max = 0;
			for (int j = 0; j < 10; j++) {
				int number = sc.nextInt();
				if (number > max)
					max = number;
			}
		System.out.println("#" + (i + 1) + " " + max);
		}		
	}
}