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
		
		int n;
		int total = 0;
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());
			total += n * n;
		}
		
		bw.write((total % 10) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
