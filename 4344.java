import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int sum = 0;

			int[] student = new int[N];
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				student[j] = temp;
				sum += temp;
			}
			
			double avg = (double) sum / N;
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(student[j] > avg) {
					cnt++;
				}
			}

			bw.write(String.format("%.3f", (cnt / (double) N) * 100) + "%\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
