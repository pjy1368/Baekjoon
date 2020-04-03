package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[10];
		int start = 1;
		int point = 1;

		while (start <= N) {
			// 끝자리 9로 만들기
			while(N % 10 != 9 && start <= N) {
				cal(N, ans, point);
				N--;
			}
			
			if (N < start) {
				break;
			}

			// 끝자리 0으로 만들기
			while(start % 10 != 0 && start <= N) {
				cal(start, ans, point);
				start++;
			}
			
			start /= 10;
			N /= 10;

			for (int i = 0; i < 10; i++) {
				ans[i] += (N - start + 1) * point;
			}

			point *= 10;
		}

		for (int i = 0; i < 10; i++) {
			bw.write(ans[i] + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void cal(int x, int[] ans, int point) {
		while(x > 0) {
			ans[x % 10] += point;
			x /= 10;
		}
	}

}