package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] words = new boolean[N][26];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);

				words[i][c - 'a'] = true;
			}
		}

		boolean[] valid = new boolean[N]; // �� �ܾ�� ��� ���ĺ��� ����ϰ� �ִ��� Ȯ��.
		Arrays.fill(valid, true);

		int[] cnt = new int[N]; // �� �ܾ�� �ؾ���� ���ĺ��� ����.

		StringBuilder sb = new StringBuilder();
		int ans = N; // ��� �� ����� ���¿��� ����.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			char x = st.nextToken().charAt(0);

			if (o == 1) {
				for (int j = 0; j < N; j++) {
					// �ؾ���� ���ĺ��� �ܾ� ��Ͽ� ���� ���� ���
					if (words[j][x - 'a']) {
						cnt[j]++;
						if (valid[j]) {
							ans--;
							valid[j] = false;
						}
					}
				}
			} else if (o == 2) {
				for (int j = 0; j < N; j++) {
					// ����Ϸ��� ���ĺ��� �ܾ� ��Ͽ� ���� �ְ�, ��� ���ĺ��� ����� �ܾ �ƴ� ���.
					if (!valid[j] && words[j][x - 'a']) {
						cnt[j]--;

						if (cnt[j] == 0) {
							valid[j] = true;
							ans++;
						}
					}
				}
			}

			sb.append(ans + "\n");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}