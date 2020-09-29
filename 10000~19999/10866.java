import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String input = bf.readLine();
			if (input.equals("pop_front")) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					int temp = deque.removeFirst();
					bw.write(temp + "\n");
				}
			} else if (input.equals("pop_back")) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					int temp = deque.removeLast();
					bw.write(temp + "\n");
				}
			} else if (input.equals("size")) {
				bw.write(deque.size() + "\n");
			} else if (input.equals("empty")) {
				if (deque.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (input.equals("front")) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.getFirst() + "\n");
				}
			} else if (input.equals("back")) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.getLast() + "\n");
				}
			} else {
				StringTokenizer st = new StringTokenizer(input);
				String push = st.nextToken();
				if (push.equals("push_front")) {
					deque.addFirst(Integer.parseInt(st.nextToken()));
				} else {
					deque.addLast(Integer.parseInt(st.nextToken()));
				}

			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
