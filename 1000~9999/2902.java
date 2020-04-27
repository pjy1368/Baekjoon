package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split("-");
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < input.length; i++) {
			answer.append(input[i].charAt(0));
		}

		bw.write(answer.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}