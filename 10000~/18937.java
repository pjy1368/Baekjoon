import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int res = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 돌을 뒤로 보내는 것은 승패의 의미가 없음.
			int temp = Integer.parseInt(st.nextToken());

			res ^= (temp - 2);
		}

		String kingName = br.readLine();

		bw.write((res != 0) ? kingName : (kingName.equals("Whiteking")) ? "Blackking" : "Whiteking");
		bw.flush();
		bw.close();
		br.close();
	}

}