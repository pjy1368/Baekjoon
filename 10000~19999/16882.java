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

		int N = Integer.parseInt(br.readLine());

		// 예외 처리.
		if (N == 1) {
			bw.write("koosaga");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		boolean isOdd = false;
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i - 1]) {
				cnt++;
			} else {
				// cnt가 홀수인 수가 하나라도 있으면
				// 선공이 이김.
				if (cnt % 2 == 1) {
					isOdd = true;
					break;
				}

				cnt = 1;
			}
		}

		// "7 7 7"과 같이 한 방향으로 수가 나열되어
		// 위 반복문에서 cnt가 홀수인지 검사 못했을 경우를 대비하여
		// 한 번 더 검사.
		if (cnt % 2 == 1) {
			isOdd = true;
		}

		bw.write(isOdd ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

}