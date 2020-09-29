package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int safe;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		safe = 0;
		boolean[][] visited = new boolean[N][M];
		boolean[][] past_visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Recursive(i, j, visited, past_visited);
			}
		}

		bw.write(safe + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Recursive(int x, int y, boolean[][] visited, boolean[][] past_visited) {
		if (past_visited[x][y]) {
			return;
		} else if (visited[x][y]) {
			safe++;
			return;
		}

		visited[x][y] = true;
		switch (map[x][y]) {
		case 'U':
			Recursive(x - 1, y, visited, past_visited);
			break;
		case 'L':
			Recursive(x, y - 1, visited, past_visited);
			break;
		case 'R':
			Recursive(x, y + 1, visited, past_visited);
			break;
		case 'D':
			Recursive(x + 1, y, visited, past_visited);
			break;
		default:
			return;
		}
		
		past_visited[x][y] = true;
	}

}