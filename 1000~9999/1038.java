package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N < 10) {
			bw.write(N + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		if (N > 1022) { // 1022번째 수는 9876543210이고, 이것보다 큰 감소하는 수는 존재하지 않는다.
			bw.write("-1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		Queue<Long> q = new LinkedList<>();
		long[] dp = new long[1023];

		for (int i = 1; i < 10; i++) {
			q.offer((long) i);
			dp[i] = i;
		}

		int index = 10;
		while (!q.isEmpty()) {
			// 큐에 존재하는 감소하는 수에서 추가적으로 일의자리보다 작은 값을 넣어본다.
			// ex) val = 32 이라고 하면, 321과 320을 큐에 추가적으로 넣어줄 수 있다.
			long val = q.poll();
			long lastNum = val % 10;

			for (int i = 0; i < lastNum; i++) {
				long temp = val * 10 + i;
				q.offer(temp);
				dp[index++] = temp;
			}

		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
