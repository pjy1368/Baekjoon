package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Emoticon {
	int screen;
	int clipBoard;
	int count;

	Emoticon(int screen, int clipBoard, int count) {
		this.screen = screen;
		this.clipBoard = clipBoard;
		this.count = count;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = Integer.parseInt(br.readLine());

		Queue<Emoticon> q = new LinkedList<>();
		boolean[][] visited = new boolean[2000][2000];

		q.offer(new Emoticon(1, 0, 0));
		visited[1][0] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			Emoticon e = q.poll();

			if (e.screen == S) {
				cnt = e.count;
				break;
			}

			// 1번 과정
			if (!visited[e.screen][e.screen]) {
				visited[e.screen][e.screen] = true;
				q.offer(new Emoticon(e.screen, e.screen, e.count + 1));
			}

			// 2번 과정
			if (e.clipBoard != 0 && e.screen + e.clipBoard < 2000 && !visited[e.screen + e.clipBoard][e.clipBoard]) {
				visited[e.screen + e.clipBoard][e.clipBoard] = true;
				q.offer(new Emoticon(e.screen + e.clipBoard, e.clipBoard, e.count + 1));
			}

			// 3번 과정
			if (e.screen >= 1 && !visited[e.screen - 1][e.clipBoard]) {
				visited[e.screen - 1][e.clipBoard] = true;
				q.offer(new Emoticon(e.screen - 1, e.clipBoard, e.count + 1));
			}

		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}