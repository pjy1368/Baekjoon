package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		Character[] arr = new Character[input.length()];
		for(int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i);
		}
		Arrays.sort(arr, Comparator.reverseOrder());
		
		String ans = "";
		for(int i = 0; i < input.length(); i++) {
			ans += arr[i];
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
