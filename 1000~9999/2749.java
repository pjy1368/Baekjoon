package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int MOD = 1000000;

		long N = Long.parseLong(br.readLine());
		long[] arr = new long[1500050];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= 1500000; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] % MOD;
		}

		bw.write(arr[(int) (N % 1500000)] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}