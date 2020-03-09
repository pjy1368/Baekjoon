import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static ArrayList<Point> points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		map = new int[10][10];
		points = new ArrayList<>();

		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					points.add(new Point(i, j));
				}
			}
		}

		DFS(0);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int index) {
		if (index == points.size()) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		} else {
			Point p = points.get(index);
			for (int i = 1; i <= 9; i++) {
				if (checkMap(p.x, p.y, i)) {
					map[p.x][p.y] = i;
					DFS(index + 1);
					map[p.x][p.y] = 0;
				}
			}
		}
	}

	public static boolean checkMap(int x, int y, int value) {
		// 가로
		for (int i = 1; i <= 9; i++) {
			if (map[x][i] == value) {
				return false;
			}
		}

		// 세로
		for (int i = 1; i <= 9; i++) {
			if (map[i][y] == value) {
				return false;
			}
		}

		// 3x3 사각형
		for(int i = ((x - 1) / 3) * 3 + 1; i < ((x - 1) / 3) * 3 + 4; i++) {
			for(int j = ((y - 1) / 3) * 3 + 1; j < ((y - 1) / 3) * 3 + 4; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}

}
