package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 무한대의 범위를 갖는 자료형인 BigInteger 활용.
		BigInteger a = BigInteger.ONE; // 1
		BigInteger b = BigInteger.ONE; // 1

		for (int i = 0; i < m; i++) {
			a = a.multiply(new BigInteger(String.valueOf(n - i))); // 곱하기
			b = b.multiply(new BigInteger(String.valueOf(i + 1))); // 곱하기
		}

		BigInteger ans = a.divide(b); // 나누기
		bw.write(ans + "\n");

		bw.flush();
		br.close();
		bw.close();
	}
}
