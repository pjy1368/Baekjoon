import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		int P = Integer.parseInt(st.nextToken());

		Vector<String> v = new Vector<>();
		v.add(A);

		int cnt = 1;
		while (true) {
			String temp = v.get(cnt - 1);
			int result = 0;

			for (int i = 0; i < temp.length(); i++) {
				result += Math.pow(Integer.parseInt(String.valueOf(temp.charAt(i))), P);
			}

			if (v.contains(String.valueOf(result))) {
				bw.write(v.indexOf(String.valueOf(result)) + "\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}

			v.add(String.valueOf(result));
			cnt++;
		}
	}

}
