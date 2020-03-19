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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int numerator = 1;
		for(int i = 0; i < K; i++) {
			numerator *= N;
			N--;
		}
		
		int denominator = 1;
		for(int i = 2; i <= K; i++) {
			denominator *= i;
		}
		
		bw.write((numerator / denominator) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
