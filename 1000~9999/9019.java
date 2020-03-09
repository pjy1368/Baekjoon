import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Command {
	int n;
	String restore;

	Command(int n, String restore) {
		this.n = n;
		this.restore = restore;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			bw.write(BFS(A, B) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static String BFS(int A, int B) {
		Queue<Command> q = new LinkedList<>();
		q.offer(new Command(A, ""));
		boolean[] visit = new boolean[10000];
		visit[A] = true;

		while (!q.isEmpty()) {
			Command c = q.poll();

			if (c.n == B) {
				return c.restore;
			}

			// D 명령어 실행
			int commandD = (c.n * 2) % 10000;
			if (!visit[commandD]) {
				visit[commandD] = true;
				q.offer(new Command(commandD, c.restore + "D"));
			}

			// S 명령어 실행
			int commandS = (c.n == 0) ? 9999 : c.n - 1;
			if (!visit[commandS]) {
				visit[commandS] = true;
				q.offer(new Command(commandS, c.restore + "S"));
			}

			// L 명령어 실행
			int commandL = (c.n % 1000) * 10 + (c.n / 1000);
			if (!visit[commandL]) {
				visit[commandL] = true;
				q.offer(new Command(commandL, c.restore + "L"));
			}

			// R 명령어 실행
			int commandR = (c.n % 10) * 1000 + (c.n / 10);
			if (!visit[commandR]) {
				visit[commandR] = true;
				q.offer(new Command(commandR, c.restore + "R"));
			}

		}
		return null;

	}

}
