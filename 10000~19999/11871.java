package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int result = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			result ^= (temp % 2 != 0) ? (temp + 1) / 2 : (temp - 1) / 2;
		}

		bw.write((result != 0) ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

}