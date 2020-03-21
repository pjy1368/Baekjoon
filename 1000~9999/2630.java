package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int b, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		b = w = 0;
		recursion(N, 0, 0);
		bw.write(w + "\n");
		bw.write(b + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recursion(int n, int startX, int startY) {
		int color = map[startX][startY];
		for (int i = startX; i < startX + n; i++) {
			for (int j = startY; j < startY + n; j++) {
				if (map[i][j] != color) {
					recursion(n / 2, startX, startY);
					recursion(n / 2, startX + n / 2, startY);
					recursion(n / 2, startX, startY + n / 2);
					recursion(n / 2, startX + n / 2, startY + n / 2);
					return;
				}
			}
		}
		if (color == 1) {
			b++;
		} else {
			w++;
		}
	}

}
