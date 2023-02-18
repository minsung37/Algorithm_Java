package algorithm.IM;

import java.util.Scanner;

public class q_비밀_이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int n = word.length();
		int r = 1;
		int c = n;
		// r, c 구하기
		for (int i = 1; i <= Math.round(Math.sqrt(n)); i++) {
			if (n % i == 0) {
				r = i;
				c = n / r;				
			}
		}
		// 배열만들기
		char[][] pw = new char[c][r];
		int idx = 0;
		for (int i = 0; i < c; i++)
			for (int j = 0; j < r; j++)
				pw[i][j] = word.charAt(idx++);
	
		// 왼쪽컬럼부터 아래방향으로 읽기
		for (int j = 0; j < r; j ++)
			for (int i = 0; i < c; i++)
				System.out.print(pw[i][j]);
	}
}