package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] prime = Eratos(N, M);
		int min = -1;
		int sum = 0;

		for (int i = N; i <= M; i++) {
			if (prime[i]) {
				if(min == -1) {
					min = i;
				}
				sum += i;
			}
		}

		if (min == -1) {
			bw.write("-1\n");
		} else {
			bw.write(sum + "\n");
			bw.write(min + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean[] Eratos(int N, int M) {
		boolean[] prime = new boolean[M + 1];
		prime[0] = prime[1] = false;

		for (int i = 2; i <= M; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= M; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= M; j += i) {
					prime[j] = false;
				}
			}
		}

		return prime;
	}

}
