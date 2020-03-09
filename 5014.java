import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x;
	int cnt;

	Location(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int F, S, G, U, D;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 건물의 최대 층
		S = Integer.parseInt(st.nextToken()); // 현재 강호가 위치한 층
		G = Integer.parseInt(st.nextToken()); // 강호가 가야하는 층
		U = Integer.parseInt(st.nextToken()); // 한 번의 위로 가는 층의 수
		D = Integer.parseInt(st.nextToken()); // 한 번의 아래로 가는 층의 수

		ans = 0;
		BFS();

		bw.write(((ans == -1) ? "use the stairs" : ans) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS() {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(S, 0));
		boolean[] visit = new boolean[F + 1];
		visit[S] = true;

		while (!q.isEmpty()) {
			Location lc = q.poll();

			if (lc.x == G) {
				ans = lc.cnt;
				return;
			}

			if (lc.x + U > F || lc.x - D < 0) {
				continue;
			}

			if (!visit[lc.x + U]) {
				visit[lc.x + U] = true;
				q.offer(new Location(lc.x + U, lc.cnt + 1));
			}

			if (!visit[lc.x - D]) {
				visit[lc.x - D] = true;
				q.offer(new Location(lc.x - D, lc.cnt + 1));
			}

		}
		ans = -1;
	}

}
