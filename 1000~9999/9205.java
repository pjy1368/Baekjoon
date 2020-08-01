package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		ArrayList<Point> a; // 집, 편의점, 페스티벌에 위치를 저장하는 배열
		boolean[][] isSearch;
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			a = new ArrayList<>();
			
			// 집, 편의점, 페스티벌에 위치를 저장함.
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				a.add(new Point(x, y));
			}
			
			isSearch = new boolean[N + 2][N + 2];
			
			// 맨해튼 거리 1000m 이하를 만족하는 두 정점을 찾음.
			// 그 두 거리는 서로 연결되어있다고 판단하고,
			// 경로 배열에 true 처리를 함.
			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (Manhattan(a.get(i), a.get(j)) <= 1000) {
						isSearch[i][j] = isSearch[j][i] = true;
					}
				}
			}
			
			fload(isSearch, N);
			
			sb.append((isSearch[0][N + 1] ? "happy" : "sad") + '\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 맨해튼 거리
	public static int Manhattan(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	// 플로이드 와샬 알고리즘
	public static void fload(boolean[][] isSearch, int N) {
		for(int k = 0; k < N + 2; k++) {
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					if(isSearch[i][k] && isSearch[k][j]) {
						isSearch[i][j] = true;
					}
				}
			}
		}
	}

}
