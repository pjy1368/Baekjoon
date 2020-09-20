import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] arr = new boolean[1000001];
		arr[1] = true;
		arr[2] = false;

		// N이 제곱수면 선공이 무조건 이김.
		for (int i = 1; i * i <= 1000000; i++) {
			arr[i * i] = true;
		}

		// 현재 상황이 선공이 패배하는 상황이라면,
		// 이 상황을 만드는 모든 상황은 승리하는 상황임.
		for (int i = 2; i <= 1000000; i++) {
			if (!arr[i]) {
				for (int j = 1; j * j + i <= 1000000; j++) {
					arr[i + j * j] = true;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append((arr[N] ? "koosaga" : "cubelover") + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}