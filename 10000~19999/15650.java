package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		perm(arr, output, visited, 0, N, M);

		bw.flush();
		bw.close();
		br.close();
	}
	
	// 순열.
	public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			if (isUp(output, r)) {
				for (int i = 0; i < r; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
	
	// 오름차순인지 판단.
	public static boolean isUp(int[] output, int r) {
		for (int i = 0; i < r - 1; i++) {
			if (output[i] > output[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
