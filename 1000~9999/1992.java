import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}

		divide(0, 0, N);
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean check(int x, int y, int N) {
		int test = map[x][y];
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (test != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void divide(int x, int y, int N) {
		if (check(x, y, N)) {
			sb.append(map[x][y]);
			return;
		}
		
		sb.append("(");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int num = N / 2;
				divide(x + num * i, y + num * j, num);
			}
		}
		sb.append(")");
	}

}
