import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static int find(int[] parent, int x) {
		return parent[x];
	}

	public static void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);

		if (x == y) {
			return;
		}

		for (int i = 1; i < parent.length; i++) {
			if (find(parent, i) == y) {
				parent[i] = x;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int E = N;

			ArrayList<ArrayList<Integer>> a = new ArrayList<>();
			for (int j = 0; j <= N; j++) {
				a.add(new ArrayList<>());
			}

			int[] parent = new int[N + 1];
			for (int m = 1; m <= N; m++) {
				parent[m] = m;
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 1; k <= E; k++) {
				int f = Integer.parseInt(st.nextToken());

				union(parent, k, f);
			}

			Set<Integer> set = new HashSet<>();
			for (int n = 1; n <= N; n++) {
				set.add(parent[n]);
			}

			bw.write(set.size() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
