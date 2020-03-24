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

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		if (A == C) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		A %= C; // A % C를 하고 넘겨 주어야 한다.
		bw.write(recursion(A, B, C) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long recursion(long A, long B, long C) {
		if (B == 1) {
			return A;
		}

		long temp = recursion(A, B / 2, C);
		long result = temp * temp % C;

		// a^5 = a^2 x a^2 x a처럼 지수가 홀수일 때는 맨끝에 a를 한 번 더 곱해주어야 함.
		if (B % 2 != 0) {
			result = result * A % C;
		}

		return result % C;
	}

}
