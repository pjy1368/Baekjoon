package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		long total = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			total += arr[i];
		}
		Arrays.sort(arr);
		
		long ans = 0;
		for(int i = 0; i < N; i++) {
			long temp = arr[i];
			total -= temp;
			ans += temp * total;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}