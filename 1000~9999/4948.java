package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = "";
		while(!(input = br.readLine()).equals("0")) {
			int N = Integer.parseInt(input);
			int cnt = Eratos(N);
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static int Eratos(int N) {
		int M = 2 * N;
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

		int cnt = 0;
		for(int i = N + 1; i <= M; i++) {
			if(prime[i]) {
				cnt++;
			}
		}
		return cnt;
	}

}
