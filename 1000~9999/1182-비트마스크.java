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
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i = 1; i < (1 << N); i++) {
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
			
			if(sum == S) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
