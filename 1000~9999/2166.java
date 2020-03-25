package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		double[] x = new double[N + 1];
		double[] y = new double[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}

		x[N] = x[0];
		y[N] = y[0];
		double total = 0;
		for (int i = 0; i < N; i++) {
			total += (x[i] + x[i + 1]) * (y[i] - y[i + 1]);
		}

		bw.write(String.format("%.1f", (Math.abs(total)) / 2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
