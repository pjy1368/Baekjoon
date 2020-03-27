package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i + 1;
		}

		boolean[] visited = new boolean[N + 1];
		BackTracking(arr, M, visited, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BackTracking(int[] arr, int M, boolean[] visited, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				BackTracking(arr, M, visited, cnt + 1);
				visited[i] = false;
			}
		}
	}

}