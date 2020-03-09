import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String input = bf.readLine();
			if (input.equals("pop")) {
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					int temp = q.poll();
					bw.write(temp + "\n");
				}
			} else if (input.equals("size")) {
				bw.write(q.size() + "\n");
			} else if (input.equals("empty")) {
				if (q.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (input.equals("front")) {
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(q.peek() + "\n");
				}
			} else if (input.equals("back")) {
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					Iterator<Integer> it = q.iterator();
					int temp = it.next();
					while(it.hasNext()) {
						temp = it.next();
					}
					bw.write(temp + "\n");
				}
			} else {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				q.offer(Integer.parseInt(st.nextToken()));
			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
