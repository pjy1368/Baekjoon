package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String explosion = br.readLine();

		char[] output = new char[str.length()];
		int index = 0; // output의 index

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 폭발 문자열의 맨 끝과 c가 같은 경우
			if (explosion.charAt(explosion.length() - 1) == c) {
				if (index < explosion.length() - 1) { // output에서 폭발 문자열을 검사할 만큼의 길이가 확보되어있지 않은 경우.
					output[index++] = c; // output에 c를 이어 붙임.
				} else { // output에서 폭발 문자열을 검사할 만큼의 길이가 확보되어있는 경우.
					boolean ok = true;
					// output에서 c를 기점으로 그 앞쪽 문자열이 폭발 문자열과 동일한지 확인.
					for (int j = index - 1, k = explosion.length() - 2; k >= 0; j--, k--) {
						if (output[j] != explosion.charAt(k)) { // 폭발 문자열과 다른 문자가 있음.
							ok = false;
							break;
						}
					}

					if (ok) { // 폭발 문자열과 일치함.
						index = index - (explosion.length() - 1); // index를 폭발 문자열 이전으로 되돌림.
					} else { // 폭발 문자열과 일치하지 않음.
						output[index++] = c; // output에 c를 이어 붙임.
					}
				}
			} else { // 폭발 문자열의 맨 끝과 c가 다른 경우
				output[index++] = c; // output에 c를 이어 붙임.
			}
		}

		StringBuilder ans = new StringBuilder();
		if (index == 0) { // output에 문자열이 들어있지 않은 경우.
			ans.append("FRULA");
		} else { // output에 문자열이 들어있는 경우.
			for (int i = 0; i < index; i++) {
				ans.append(output[i]);
			}
		}

		bw.write(ans.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}