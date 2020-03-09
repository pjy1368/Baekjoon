import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void DFS(ArrayList<ArrayList<Integer>> a, int[] color, int start, int cnt) {
		color[start] = cnt;
		// 0은 방문 안 함
		// 1은 첫 번째 그룹
		// 2는 두 번째 그룹
		
		for (int y : a.get(start)) {
			if (color[y] == 0) {
				DFS(a, color, y, 3 - cnt);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());

		outer: for (int i = 1; i <= K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Integer>> a = new ArrayList<>();

			for (int k = 0; k <= v; k++) {
				a.add(new ArrayList<>());
			}

			int[] color = new int[v + 1];

			for (int j = 1; j <= e; j++) {
				st = new StringTokenizer(br.readLine());

				int f = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());

				a.get(f).add(g);
				a.get(g).add(f);
			}

			for (int c = 1; c <= v; c++) {
				if (color[c] == 0) {
					DFS(a, color, c, 1);
				}
			}

			for (int m = 1; m <= v; m++) {
				for (int n : a.get(m)) {
					if (color[m] == color[n]) {
						bw.write("NO\n");
						continue outer;
					}
				}
			}
			bw.write("YES\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
