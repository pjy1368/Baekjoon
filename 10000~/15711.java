package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] prime = Eratos(2000000); // 200�� ������ �Ҽ��� �迭. �� 15�� ��

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long C = A + B;

			if (C < 4) { // C�� 2�� ���� 3�� ���� �Ҽ� 2���� �и��� �� ����.
				bw.write("NO\n");
				continue;
			}

			if (C % 2 == 0) { // �������� ������ ���Ͽ� ������ ��.
				bw.write("YES\n");
			} else {
				// Ȧ���� N = 2 + (N - 2)�� �и��� �� ����.
				// �� �츮�� �� ���� N - 2�� �Ҽ����� Ȯ�θ� �ϸ� ��.
				C = C - 2;

				if (isPrime(prime, C)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	// �Ҽ��� ��� �迭�� ��ȯ�ϴ� �Լ�. �����佺�׳׽��� ü Ȱ��.
	public static int[] Eratos(int MAX) {
		int size = 0;
		boolean[] prime = new boolean[MAX + 1];
		prime[0] = prime[1] = false;

		for (int i = 2; i <= MAX; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= MAX; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					prime[j] = false;
				}
			}
		}

		for (int i = 2; i <= MAX; i++) {
			if (prime[i]) {
				size++;
			}
		}

		int[] arr = new int[size];
		int index = 0;
		for (int i = 2; i <= MAX; i++) {
			if (prime[i]) {
				arr[index++] = i;
			}
		}

		return arr;
	}
	
	// n�� �Ҽ����� �ƴ��� Ȯ���ϴ� �Լ�.
	public static boolean isPrime(int[] prime, long n) {
		double sqrt = Math.sqrt(n);
		// 3, 5, 7, 9,... ���� ��Ʈ n���� Ȧ���� ������ �ͺ��� ��Ʈ n�� ������ �Ҽ��� �������� ���� �� ������.
		// �� �������� Vector�� ���� �ð� �ʰ��� ���� �Ϻη� �迭�� ����Ͽ���.
		for (int i = 0; i < prime.length && prime[i] <= sqrt; i++) {
			if (n % prime[i] == 0) {
				return false;
			}
		}
		return true;
	}
}