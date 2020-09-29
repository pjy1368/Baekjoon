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
		int[] input = new int[N];

		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			result ^= input[i];
		}

		if (result == 0) { // 초기 XOR 합이 0이면 무조건 후공이 이김.
			bw.write("0\n");
		} else { // 각 돌 더미의 돌 개수를 1개씩 줄여보면서 XOR 합을 계산.
			int ans = 0;
			for (int i = 0; i < N; i++) {
				result = 0;

				// i를 제외한 나머지 XOR 합을 계산.
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}

					result ^= input[j];
				}

				// i번 째 돌 더미의 돌 개수를 1개씩 줄여 봄.
				for (int j = input[i] - 1; j >= 0; j--) {
					int temp = result;

					// 새롭게 만들어진 XOR 합이 0이 되면 선공이 이김.
					if ((temp ^= j) == 0) {
						ans++;
					}
				}
			}

			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
