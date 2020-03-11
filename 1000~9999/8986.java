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
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());
			arr[i] = temp;
		}

		long lo = 0, hi = arr[N - 1];
		while (hi - lo >= 3) { // (참고) 이 방법 외의 임의로 100번을 돌려도 10의 -7제곱이므로 오차 범위에서 벗어나지 않는다.
			long p = (2 * lo + hi) / 3;
			long q = (lo + 2 * hi) / 3;

			if (Sum(arr, p) <= Sum(arr, q)) {
				hi = q;
			} else {
				lo = p;
			}
		}

		long result = Long.MAX_VALUE;
		for (int i = (int) lo; i <= (int) hi; i++) {
			result = Math.min(Sum(arr, i), result);
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long Sum(long[] arr, long x) {
		long result = 0;

		for (int i = 1; i < arr.length; i++) {
			result += Math.abs(i * x - arr[i]);
		}

		return result;
	}

}
