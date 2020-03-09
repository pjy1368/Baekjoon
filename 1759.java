import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr;
	static boolean[] choose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 암호의 길이
		C = Integer.parseInt(st.nextToken()); // 사용 가능한 알파벳 수

		arr = new char[C];
		choose = new boolean[C];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		DFS(0, 0, 0, 0);

		// bw.flush();
		bw.close();
		br.close();
	}

	// 시작점, 선택된 문자의 개수, 자음의 개수, 모음의 개수
	public static void DFS(int start, int depth, int ja, int mo) {
		for (int i = start; i < C; i++) {
			choose[i] = true;
			DFS(i + 1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (check(arr[i]) ? 1 : 0));
			choose[i] = false;
		}

		if (depth == L && ja >= 2 && mo >= 1) {
			print();
		}
	}

	// 출력
	public static void print() {
		for (int i = 0; i < C; i++) {
			if (choose[i]) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}

	// 모음 체크
	public static boolean check(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
			return true;
		} else {
			return false;
		}
	}

}
