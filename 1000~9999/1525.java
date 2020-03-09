import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Puzzle {
	String input;
	int cnt;

	Puzzle(String input, int cnt) {
		this.input = input;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] next = { -1, 1, -3, 3 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String input = "";
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				input += st.nextToken();
			}
		}

		ans = 0;
		BFS(input);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(String input) {
		int zeroLocation = 0;
		Queue<Puzzle> q = new LinkedList<>();
		q.offer(new Puzzle(input, 0));
		Set<String> s = new HashSet<>();
		s.add(input);

		while (!q.isEmpty()) {
			Puzzle puzzle = q.poll();

			if (puzzle.input.equals("123456780")) {
				ans = puzzle.cnt;
				return;
			}

			for (int i = 0; i < puzzle.input.length(); i++) {
				if (puzzle.input.charAt(i) == '0') {
					zeroLocation = i;
					break;
				}
			}

			for (int i = 0; i < 4; i++) {
				int x = zeroLocation + next[i];
				if (x < 0 || (zeroLocation % 3 == 0 && i == 0) || (zeroLocation % 3 == 2 && i == 1) || x >= 9) {
					continue;
				}

				char[] c = puzzle.input.toCharArray();
				char temp = c[x];
				c[x] = c[zeroLocation];
				c[zeroLocation] = temp;

				String output = new String(c);
				if (!s.contains(output)) {
					s.add(output);
					q.offer(new Puzzle(output, puzzle.cnt + 1));
				}

			}
		}

		ans = -1;
	}

}
