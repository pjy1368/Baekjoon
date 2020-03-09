import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Password {
	int num;
	int cnt;

	Password(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == B) {
				sb.append("0\n");
				continue;
			}

			BFS(A, B);

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int A, int B) {
		Queue<Password> q = new LinkedList<>();
		q.offer(new Password(A, 0));
		boolean[] visit = new boolean[10000];
		visit[A] = true;

		boolean[] bool = isPrime(9999);

		while (!q.isEmpty()) {
			Password ps = q.poll();
			String input = String.valueOf(ps.num);

			if (ps.num == B) {
				sb.append(ps.cnt + "\n");
				return;
			}

			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					for (int j = 1; j <= 9; j++) {
						StringBuilder str = new StringBuilder(input);
						str.setCharAt(0, (char) ('0' + j));
						int temp = Integer.parseInt(str.toString());
						if (!visit[temp] && bool[temp]) {
							visit[temp] = true;
							q.offer(new Password(temp, ps.cnt + 1));
						}
					}
				} else {
					for (int j = 0; j <= 9; j++) {
						StringBuilder str = new StringBuilder(input);
						str.setCharAt(i, (char) ('0' + j));
						int temp = Integer.parseInt(str.toString());
						if (!visit[temp] && bool[temp]) {
							visit[temp] = true;
							q.offer(new Password(temp, ps.cnt + 1));
						}
					}
				}
			}

		}
		sb.append("Impossible\n");
	}

	public static boolean[] isPrime(int n) {
		boolean[] primeList = new boolean[n + 1];

		primeList[0] = primeList[1] = false;

		for (int i = 2; i <= n; i++) {
			primeList[i] = true;
		}

		for (int i = 2; (i * i) <= n; i++) {
			if (primeList[i]) {
				for (int j = i * i; j <= n; j += i)
					primeList[j] = false;
			}
		}

		return primeList;
	}

}
