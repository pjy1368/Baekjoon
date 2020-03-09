import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		if ((N % 4 == 0 && N % 100 != 0) || (N % 4 == 0 && N % 400 == 0)) {
			ans = 1;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
