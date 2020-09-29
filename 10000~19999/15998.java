package noj.am;

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

		long a, b;
		long minB = (long) 10e18; // 아래서 언급될 b의 최솟값
		long balance = 0; // 현재 잔액

		boolean valid = true;
		long M = 0; // 최소 출금 금액
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken()); // 입금 또는 출금액
			b = Long.parseLong(st.nextToken()); // 입금 또는 출금을 한 뒤 남은 잔액

			// 현재 잔액에서 출금액을 뻈을 때, 음수가 나올 경우
			// 계좌에서 M만큼 출금해야 함.
			if (balance + a < 0) {
				// (balance + M x n) + a = b -> n은 M을 출금하는 횟수.
				// M x n = b - a - balance
				// 자동 충전액에 대한 식은 M x n이므로
				// 모든 자동 충전액은 M을 약수로 가진다는 사실을 알 수 있다.
				// 결과적으로, 이 조건을 만족하는 반복문을 돌 때마다 M은 최대공약수로 초기화해주면 된다.
				// M의 임시 변수를 temp를 두었음.
				long temp = b - a - balance;

				// minB는 b의 최솟값이 되도록 초기화.
				if (b != 0 && b < minB) {
					minB = b;
				}

				if (M == 0) {
					// M이 0일 떄는
					// 단순히 temp를 대입하면 됨.
					M = temp;
				} else {
					// M이 0이 아닐 떄는
					// M과 temp의 최대공약수를 구해서
					// M에 대입함.
					M = GCD(M, temp);

					// 출금 또는 입금을 하고 난 뒤, minB가 M보다 크거나 같으면 모순.
					// 단, minB = (long)10e18일 때는 minB의 초기 상태이므로
					// 위의 모순이 생기더라도 무시할 수 있음.
					if (M <= minB && minB != (long) 10e18) {
						valid = false;
						break;
					}
				}
			} else { // 현재 잔액에서 입금을 하거나, 현재 잔액을 초과하지 않는 만큼 출금을 할 경우
				// 현재 잔액에서 입금하거나 출금을 한 결과가 b와 다르면 모순.
				if (balance + a != b) {
					valid = false;
					break;
				}
			}

			// 과거 잔액을 현재 잔액으로 초기화.
			balance = b;
		}

		if (valid && M != 0) {
			// 모순이 발생하지 않았고, M이 1이상의 최대 공약수를 가진 경우
			bw.write(M + "\n");
		} else if (valid && M == 0) {
			// 모순이 발생하지 않았으나, 입금 또는 출금을 했을 때
			// 현재 잔액이 음수가 발생하지 않아서 M을 계산할 일이 없던 경우
			bw.write("1\n");
		} else {
			// 모순이 발생한 경우
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	// 유클리드 호제법
	public static long GCD(long a, long b) {
		while (b > 0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}