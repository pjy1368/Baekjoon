package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		boolean[] visited = new boolean[N];
		int[] output = new int[N];
		perm(arr, visited, output, 0, N);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void perm(int[] arr, boolean[] visited, int[] output, int start, int n) {
		if (start == n) {
			for (int i = 0; i < output.length; i++) {
				sb.append(output[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[start] = arr[i];
				perm(arr, visited, output, start + 1, n);
				visited[i] = false;
			}
		}
	}

}