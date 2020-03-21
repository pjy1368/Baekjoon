package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		recursion(N, 0, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recursion(int N, int startX, int startY) {
		if (N != 2) {
			recursion(N / 2, startX, startY);
			recursion(N / 2, startX, startY + N / 2);
			recursion(N / 2, startX + N / 2, startY);
			recursion(N / 2, startX + N / 2, startY + N / 2);
			return;
		} else {
			if (startX == r && startY == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if (startX == r && startY + 1 == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if (startX + 1 == r && startY == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if (startX + 1 == r && startY + 1 == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
		}
	}

}
