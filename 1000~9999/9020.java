package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] prime = Eratos(10001);
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			for (int j = N / 2; j >= 2; j--) { 
				// (N - j) - j = N - 2 * j�̹Ƿ� j�� �ִ��� ���� ���� ���̰� �۴�.
				if (prime[j] && prime[N - j]) {
					bw.write(j + " " + (N - j) + "\n");
					break; // ����, �� �� if���� �����ϸ�, �ݺ����� ������ �Ѵ�.
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean[] Eratos(int N) {
		boolean[] prime = new boolean[N + 1];
		prime[0] = prime[1] = false;

		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}

		return prime;
	}

}
