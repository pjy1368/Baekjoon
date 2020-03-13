package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		combination(arr, visited, 0, N, 3, M);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r, int m) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}

			if (sum <= m) {
				ans = Math.max(ans, sum);
			}

			return;
		} else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(arr, visited, i + 1, n, r - 1, m);
				visited[i] = false;
			}
		}
	}

}
