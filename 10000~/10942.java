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

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N + 1][N + 1];

		// ���̰� 1�̸� ������ �Ӹ���� ��
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}

		// ���̰� 2�� ��, �� ���� ���ƾ� �Ӹ���� ��
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i + 1]) {
				dp[i][i + 1] = true;
			}
		}

		// Ư�� ���� �Ӹ���� ���� ���,
		// �� �� �� �հ� �� �� ���� ���� �������ν�
		// ���ο� �Ӹ���� ���� ���� �� �ִ�.
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			sb.append(dp[S][E] ? "1\n" : "0\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
