package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		DFS("", 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(String s, int len) {
		if (N == len) {
			sb.append(s + "\n");
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isPrime(Integer.parseInt(s + i))) {
					DFS(s + i, len + 1);
				}
			}
		}
	}

	public static boolean isPrime(int k) {
		if (k == 1) {
			return false;
		}

		int sqrt = (int) Math.sqrt(k);
		for (int i = 2; i <= sqrt; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}

}
