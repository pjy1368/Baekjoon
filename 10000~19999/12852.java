package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Number {
	int n;
	int cnt;
	String command;

	Number(int n, int cnt, String command) {
		this.n = n;
		this.cnt = cnt;
		this.command = command;
	}
}

public class Main {
	static int ansNum;
	static String ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		ansNum = 0;
		ans = "";
		BFS(N);

		bw.write(ansNum + "\n");
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int N) {
		Queue<Number> q = new LinkedList<>();
		q.offer(new Number(N, 0, String.valueOf(N)));
		boolean[] visited = new boolean[N + 1];

		while (!q.isEmpty()) {
			Number num = q.poll();

			if (num.n == 1) {
				ansNum = num.cnt;
				ans = num.command;
				return;
			}

			if (num.n % 3 == 0 && !visited[num.n / 3]) {
				visited[num.n / 3] = true;
				q.offer(new Number(num.n / 3, num.cnt + 1, num.command + " " + (num.n / 3)));
			}

			if (num.n % 2 == 0 && !visited[num.n / 2]) {
				visited[num.n / 2] = true;
				q.offer(new Number(num.n / 2, num.cnt + 1, num.command + " " + (num.n / 2)));
			}

			if (!visited[num.n - 1]) {
				visited[num.n - 1] = true;
				q.offer(new Number(num.n - 1, num.cnt + 1, num.command + " " + (num.n - 1)));
			}
		}
	}

}
