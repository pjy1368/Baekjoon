import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		bw.write(GCD(N, M) ? "win" : "lose");
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean GCD(long v1, long v2) {
		// v1 > v2가 되도록 조정.
		if (v1 < v2) {
			long temp = v1;
			v1 = v2;
			v2 = temp;
		}

		// 선공이 바로 v2를 0으로 만들어서 이길 수 있음.
		if (v1 % v2 == 0) {
			return true;
		}

		// 이 조건을 만족하면, 항상 큰 수를 작은 수로 계속 빼야 함.
		if (v1 - v2 < v2) {
			return !GCD(v2, v1 - v2);
		}

		// 나머지 조건은 모두 선공이 이김.
		return true;
	}

}