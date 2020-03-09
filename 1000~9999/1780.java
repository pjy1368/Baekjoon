import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] ans;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ans = new int[3];
		paper = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		for(int i = 0; i < 3; i++) {
			bw.write(ans[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void divide(int x, int y, int N) {
		if (check(x, y, N)) {
			ans[paper[x][y] + 1]++;
		} else {
			int num = N / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(x + num * i, y + num * j, num);
				}
			}

		}
	}

	public static boolean check(int x, int y, int N) {
		int test = paper[x][y];

		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (test != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
