package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char[][] whiteFirst = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	static char[][] blackFirst = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				ans = Math.min(ans, Math.min(compareWhite(i, j, map), compareBlack(i, j, map)));
			}
		}
				
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int compareWhite(int x, int y, char[][] map) {
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (map[i][j] != whiteFirst[i % 8][j % 8]) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static int compareBlack(int x, int y, char[][] map) {
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (map[i][j] != blackFirst[i % 8][j % 8]) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
