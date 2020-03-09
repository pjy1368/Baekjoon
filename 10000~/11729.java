import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int total = (int) Math.pow(2, N) - 1;
		bw.write(total + "\n");
		
		Hanoi(N, 1, 2, 3);
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Hanoi(int N, int start, int mid, int end) throws IOException {
		if (N == 1) {
			bw.write(start + " " + end + "\n");
			return;
		}

		Hanoi(N - 1, start, end, mid);
		bw.write(start + " " + end + "\n");
		Hanoi(N - 1, mid, start, end);
	}

}
