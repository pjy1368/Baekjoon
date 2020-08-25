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

		if (result == 0) { // �ʱ� XOR ���� 0�̸� ������ �İ��� �̱�.
			bw.write("0\n");
		} else { // �� �� ������ �� ������ 1���� �ٿ����鼭 XOR ���� ���.
			int ans = 0;
			for (int i = 0; i < N; i++) {
				result = 0;

				// i�� ������ ������ XOR ���� ���.
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}

					result ^= input[j];
				}

				// i�� ° �� ������ �� ������ 1���� �ٿ� ��.
				for (int j = input[i] - 1; j >= 0; j--) {
					int temp = result;

					// ���Ӱ� ������� XOR ���� 0�� �Ǹ� ������ �̱�.
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
