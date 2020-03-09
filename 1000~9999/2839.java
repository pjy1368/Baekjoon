import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Candy {
	int weight;
	int cnt;

	Candy(int weight, int cnt) {
		this.weight = weight;
		this.cnt = cnt;
	}
}

public class Main {
	static int N;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		ans = -1;
		BFS();

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS() {
		Queue<Candy> q = new LinkedList<>();
		q.offer(new Candy(0, 0));
		boolean[] visit = new boolean[N + 1];
		visit[0] = true;

		while (!q.isEmpty()) {
			Candy c = q.poll();

			if (c.weight == N) {
				ans = c.cnt;
			}

			if (c.weight + 3 <= N && !visit[c.weight + 3]) {
				visit[c.weight + 3] = true;
				q.offer(new Candy(c.weight + 3, c.cnt + 1));
			}

			if (c.weight + 5 <= N && !visit[c.weight + 5]) {
				visit[c.weight + 5] = true;
				q.offer(new Candy(c.weight + 5, c.cnt + 1));
			}
		}
	}
}
