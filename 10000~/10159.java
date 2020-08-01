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
		int M = Integer.parseInt(br.readLine());

		// 문제에서 주어진대로 입력을 받음.
		boolean[][] arr = new boolean[N + 1][N + 1];

		// 문제에서 주어진 것과 반대로 입력을 받음.
		boolean[][] reverse_arr = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = true;
			reverse_arr[y][x] = true;
		}

		// 플로이드 와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}

					if (reverse_arr[i][k] && reverse_arr[k][j]) {
						reverse_arr[i][j] = true;
					}
				}
			}
		}

		// 특정 물건에 대하여 더 무거운 물건과 더 가벼운 물건 모두를 파악 가능.
		// 만약 |을 취한 값이 false라면, 그 물건과 무게 비교를 할 수 없다는 의미.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] |= reverse_arr[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) { // 자기 자신은 제외.
					continue;
				}

				// 무게 비교를 할 수 없을 경우 cnt 증가.
				if (!arr[i][j]) {
					cnt++;
				}
			}

			sb.append(cnt + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
