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

		boolean[] valid = new boolean[N]; // 각 단어마다 모든 알파벳을 기억하고 있는지 확인.
		Arrays.fill(valid, true);

		int[] cnt = new int[N]; // 각 단어마다 잊어버린 알파벳의 개수.

		StringBuilder sb = new StringBuilder();
		int ans = N; // 모두 다 기억한 상태에서 시작.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			char x = st.nextToken().charAt(0);

			if (o == 1) {
				for (int j = 0; j < N; j++) {
					// 잊어버릴 알파벳이 단어 목록에 속해 있을 경우
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
					// 기억하려는 알파벳이 단어 목록에 속해 있고, 모든 알파벳을 기억한 단어가 아닐 경우.
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