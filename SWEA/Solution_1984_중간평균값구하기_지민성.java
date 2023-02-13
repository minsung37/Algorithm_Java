package algorithm.SWEA;

import java.util.Scanner;

public class Solution_1984_중간평균값구하기_지민성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			double min = 100000;
			double max = 0;
			double sum = 0;
			for (int j = 0; j < 10; j++) {
				int number = sc.nextInt();
				if (number > max)
					max = number;
				if (number < min)
					min = number;
				sum = sum + number;
			}
			System.out.println("#" + (i + 1) + " " + Math.round((sum - min - max) / 8));
		}
	}
}