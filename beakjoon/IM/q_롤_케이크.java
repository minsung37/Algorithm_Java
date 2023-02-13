package algorithm.beakjoon.IM;
import java.util.Scanner;

public class q_롤_케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] rollCake = new int[l + 1];
		int[] cakeCount = new int[n + 1];
		int expect = 0;
		int expectPerson = 0;
		int cake = 0;
		int cakePerson = 0;
		
		
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			// 예상되는 방청객
			if ((k - p) > expect) {
				expect = k - p;
				expectPerson = i + 1;
			}

			// 케이크배치
			for (int j = p; j <=k; j++)
				if (rollCake[j] == 0)
					rollCake[j] = i + 1;
		}

		// 사람에 대해서 케이크 카운트 하기
		for (int i = 1; i <= l; i++)
			cakeCount[rollCake[i]]++;
		
		// 실제로 많이 받은 사람
		for (int i = 1; i <= n; i++) {
			if (cakeCount[i] > cake) {
				cake = cakeCount[i];
				cakePerson = i;
			}
		}

		System.out.println(expectPerson);
		System.out.println(cakePerson);
	}
}