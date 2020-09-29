package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[] dp = new int[1000001];

		for (int i = 1, cnt = 1; i <= 446; i++, cnt++) {
			int n = i * (i + 1) / 2;

			for (int j = 0; j <= cnt; j++) {
				dp[n + j] = cnt;
			}
		}

		int N = Integer.parseInt(br.readLine());

		int res = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			res ^= dp[temp];
		}

		bw.write((res != 0) ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

}