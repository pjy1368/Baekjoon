package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean isZero = false;
			if (K == 1) { // 예외 처리
				if (N % 2 == 1 && M % 2 == 1) {
					isZero = true;
				}
			} else if (N <= K || M <= K) { // 0과 1로만 된 지역 따로 처리
				if (N % 2 == 1 && M % 2 == 1) {
					isZero = true;
				} else if (N % 2 == 0 && M % 2 == 0) {
					isZero = true;
				}
			} else if (N > M) {
				int startTwo = K + 1; // 그런디 수가 처음으로 2인 x와 y좌표

				int y = M; // N보다 작은 M에 대하여 (M, M)을 찾아 올라감.
				if (y % startTwo != 0) { // (M, M)의 그런디 수가 2가 아님.
					int q = y / startTwo;

					if (q % 2 == 1) { // (M, M)의 그런디 수가 1이라면,
						int dif = N - y;

						if (dif % 2 == 1) {
							isZero = true;
						}
					} else { // (M, M)의 그런디 수가 0이라면,
						int dif = N - y;

						if (dif % 2 == 0) {
							isZero = true;
						}
					}
				}
			} else {
				int startTwo = K + 1; // 그런디 수가 처음으로 2인 x와 y좌표

				// (N, N)의 그런디 수가 2가 아니라면,
				if (N % startTwo != 0) {
					int q = N / startTwo;

					// (N, N)의 그런디 수가 1이라면,
					if (q % 2 == 1) {
						if (N % 2 == 0 && M % 2 == 1) {
							isZero = true;
						} else if (N % 2 == 1 && M % 2 == 0) {
							isZero = true;
						}
					} else { // (N, N)의 그런디 수가 0이라면,
						if (N % 2 == 0 && M % 2 == 0) {
							isZero = true;
						} else if (N % 2 == 1 && M % 2 == 1) {
							isZero = true;
						}
					}
				}
			}
			sb.append(isZero ? "cubelover\n" : "koosaga\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
