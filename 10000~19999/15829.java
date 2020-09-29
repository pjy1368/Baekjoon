package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		String input = br.readLine();

		long[] dp = new long[L];
		dp[0] = 1;
		for (int i = 1; i < L; i++) { // 31의 50제곱같이 큰 값을 사용할 때는 이렇게 미리 저장해 두자.
			dp[i] = (dp[i - 1] * 31) % 1234567891; 
		}

		long total = 0;
		for (int i = 0; i < L; i++) {
			char c = input.charAt(i);
			int temp = c - 'a' + 1;
			total = (total + temp * dp[i]) % 1234567891;
		}

		bw.write((total % 1234567891) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
