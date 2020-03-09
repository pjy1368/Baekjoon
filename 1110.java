import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int x = N;
		int cnt = 0;
		while (true) {
			if (x < 0) {
				x = x * 10;
				cnt++;
			} else {
				int q = x / 10;
				int r = x % 10;
				
				int sum = q + r;
				
				x = r * 10 + sum % 10;
				cnt++;
			}
			
			if (x == N) {
				break;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
