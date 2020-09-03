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
			if (K == 1) { // ���� ó��
				if (N % 2 == 1 && M % 2 == 1) {
					isZero = true;
				}
			} else if (N <= K || M <= K) { // 0�� 1�θ� �� ���� ���� ó��
				if (N % 2 == 1 && M % 2 == 1) {
					isZero = true;
				} else if (N % 2 == 0 && M % 2 == 0) {
					isZero = true;
				}
			} else if (N > M) {
				int startTwo = K + 1; // �׷��� ���� ó������ 2�� x�� y��ǥ

				int y = M; // N���� ���� M�� ���Ͽ� (M, M)�� ã�� �ö�.
				if (y % startTwo != 0) { // (M, M)�� �׷��� ���� 2�� �ƴ�.
					int q = y / startTwo;

					if (q % 2 == 1) { // (M, M)�� �׷��� ���� 1�̶��,
						int dif = N - y;

						if (dif % 2 == 1) {
							isZero = true;
						}
					} else { // (M, M)�� �׷��� ���� 0�̶��,
						int dif = N - y;

						if (dif % 2 == 0) {
							isZero = true;
						}
					}
				}
			} else {
				int startTwo = K + 1; // �׷��� ���� ó������ 2�� x�� y��ǥ

				// (N, N)�� �׷��� ���� 2�� �ƴ϶��,
				if (N % startTwo != 0) {
					int q = N / startTwo;

					// (N, N)�� �׷��� ���� 1�̶��,
					if (q % 2 == 1) {
						if (N % 2 == 0 && M % 2 == 1) {
							isZero = true;
						} else if (N % 2 == 1 && M % 2 == 0) {
							isZero = true;
						}
					} else { // (N, N)�� �׷��� ���� 0�̶��,
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
