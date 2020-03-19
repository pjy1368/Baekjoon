package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			bw.write("1\n");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			queue.poll();
			if(queue.size() == 1) {
				break;
			}
			
			queue.offer(queue.poll());
		}
		
		bw.write(queue.poll() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
