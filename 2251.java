import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Bottle {
	int Asize;
	int Bsize;
	int Csize;

	int A;
	int B;
	int C;

	Bottle(int Asize, int Bsize, int Csize, int A, int B, int C) {
		this.Asize = Asize;
		this.Bsize = Bsize;
		this.Csize = Csize;

		this.A = A;
		this.B = B;
		this.C = C;

	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Queue<Bottle> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		boolean[][][] visit = new boolean[201][201][201];

		q.offer(new Bottle(A, B, C, 0, 0, C));

		while (!q.isEmpty()) {
			Bottle b = q.poll();

			if (visit[b.A][b.B][b.C]) {
				continue;
			}

			visit[b.A][b.B][b.C] = true;

			if (b.A == 0) {
				if (!set.contains(b.C)) {
					set.add(b.C);
				}
			}

			// A -> B
			if (b.A + b.B > b.Bsize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A + b.B - b.Bsize, b.Bsize, b.C));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, 0, b.A + b.B, b.C));
			}

			// A -> C
			if (b.A + b.C > b.Csize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A + b.C - b.Csize, b.B, b.Csize));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, 0, b.B, b.A + b.C));
			}

			// B -> A
			if (b.B + b.A > b.Asize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.Asize, b.B + b.A - b.Asize, b.C));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.B + b.A, 0, b.C));
			}

			// B -> C
			if (b.B + b.C > b.Csize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A, b.B + b.C - b.Csize, b.Csize));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A, 0, b.C + b.B));
			}

			// C -> A
			if (b.C + b.A > b.Asize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.Asize, b.B, b.C + b.A - b.Asize));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.C + b.A, b.B, 0));
			}

			// C -> B
			if (b.C + b.B > b.Bsize) {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A, b.Bsize, b.C + b.B - b.Bsize));
			} else {
				q.offer(new Bottle(b.Asize, b.Bsize, b.Csize, b.A, b.B + b.C, 0));
			}

		}

		List<Integer> ans = new ArrayList<>(set);
		Collections.sort(ans);

		StringBuilder sb = new StringBuilder();
		sb.append(ans.get(0));
		for (int i = 1; i < ans.size(); i++) {
			sb.append(" " + ans.get(i));
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
