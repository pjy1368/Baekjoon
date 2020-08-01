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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 문제에서 주어진대로 입력을 받음.
		boolean[][] arr = new boolean[N + 1][N + 1];

		// 문제에서 주어진 것과 반대로 입력을 받음.
		boolean[][] reverse_arr = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = true;
			reverse_arr[b][a] = true;
		}

		// 플로이드 와샬 알고리즘 수행
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
				}
			}
		}

		// 플로이드 와샬 알고리즘 수행
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (reverse_arr[i][k] && reverse_arr[k][j]) {
						reverse_arr[i][j] = true;
					}
				}
			}
		}

		// 특정 학생에 대하여 키가 큰 사람과 작은 학생 모두를 파악 가능.
		// 만약 |을 취한 값이 false라면, 그 학생과 키 비교를 할 수 없다는 의미.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] |= reverse_arr[i][j];
			}
		}

		int ans = 0;
		outer: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) { // 자기 자신은 제외.
					continue;
				}

				// 키 비교를 할 수 없는 학생이 존재한다면 continue.
				if (!arr[i][j]) {
					continue outer;
				}
			}
			ans++;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
