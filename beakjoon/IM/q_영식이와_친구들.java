package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_영식이와_친구들 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int l = scanner.nextInt();
		
		int[] people = new int[n + 1];
		int count = 0;
		int init = 1;
		while (true) {
			people[init]++;
			if (people[init] == m)
				break;
			count++;
			if (people[init] % 2 == 0) {
				init = (init + n - l) % n;
			} else {
				init = (init + l) % n;
			}
		}
		System.out.println(count);
	}
}
