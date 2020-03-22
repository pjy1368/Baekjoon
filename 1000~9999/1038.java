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

		if (N > 1022) { // 1022��° ���� 9876543210�̰�, �̰ͺ��� ū �����ϴ� ���� �������� �ʴ´�.
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
			// ť�� �����ϴ� �����ϴ� ������ �߰������� �����ڸ����� ���� ���� �־��.
			// ex) val = 32 �̶�� �ϸ�, 321�� 320�� ť�� �߰������� �־��� �� �ִ�.
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
