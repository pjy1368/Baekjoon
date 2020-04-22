package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R1 = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		bw.write((2 * S - R1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}