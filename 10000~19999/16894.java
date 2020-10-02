import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());

		long temp = N;
		int cnt = 0; // N을 이루는 요소의 개수.

		// N을 이루는 요소는 특정 소수 2개여야 함.
		// 만약, 2를 넘어가면 바로 종료.
		for (long i = 2; i * i <= temp && cnt < 2; i++) {
			while (temp % i == 0) {
				temp /= i;
				cnt++; // 소수의 개수를 늘려준다.
			}
		}

		// 현재 temp가 1보다 크다는 말은
		// 지금 temp 자체가 소수를 의미함.
		// 따라서, N = x * temp로 semi-prime을 이룸.
		// 여기서 x는 위의 반복문에서 구한 하나의 소수를 의미함.
		if (temp > 1) {
			cnt++;
		}

		// semi-prime일 때만 cubelover가 승리함.
		bw.write(cnt == 2 ? "cubelover" : "koosaga");
		bw.flush();
		bw.close();
		br.close();
	}

}