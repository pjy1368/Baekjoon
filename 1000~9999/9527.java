package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken()) - 1;
		long B = Long.parseLong(st.nextToken());

		bw.write((sum(B) - sum(A)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long sum(long n) {
		long result = 0;
		long token = 1; // 2^0, 2^1, 2^2, ... 아래에 있는 now를 기준으로 now를 포함한 오른쪽 비트열의 개수.
		long prev = 0; // 아래에 있는 now가 1일 때, now 이하로 존재하는 오른쪽 비트열의 경우의 수(1일 때만).

		for (int i = 0; i < 55; i++) {
			long now = n & token; // 비트열에서 현재 가리키는 위치. (맨 오른쪽부터 한 칸씩 왼쪽으로 이동.)

			if (now != 0) {
				// n = 1111 이고, 현재 now가 맨오른쪽 비트를 가리키고 있다면,
				// 1110 ~ 1111 중에 맨오른쪽 비트가 1인 경우를 셈.

				result += prev + 1;
				prev += token; // token이 커지므로 prev도 새로 업데이트해 주어야함.
			}

			if (n - prev == 0) { // n과 prev가 같아지면, 더이상 앞에 비트가 존재하지 않는다는 의미이므로 탐색을 종료함.
				break;
			}

			// now를 기준으로 now를 포함한 오른쪽 비트열의 경우의 수 * 왼쪽 비트열의 개수를 셈.
			// 예를 들어, n = 1111이고, now = 1(맨 오른쪽)일 경우, 0000 ~ 1101(1110 보다 하나 작은 수) 중에 맨오른쪽
			// 자리 수가 1인 경우를 모두 셈.

			// 예를 들어, n = 1111이고, now = 1(오른쪽에서 2번째)일 경우, 0000 ~ 1011(1100보다 하나 작은 수) 중에
			// 오른쪽에서 2번째 자리수가 1인 경우를 모두 셈.

			result += token * (n >> (i + 1));

			token <<= 1;
		}
		return result;
	}

}