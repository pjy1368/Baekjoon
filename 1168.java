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
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;

		Vector<Integer> v = new Vector<>();
		for (int i = 1; i <= N; i++) {
			v.add(i);
		}

		int index = 0;
		bw.write("<");
		while (!v.isEmpty()) {
			index += K;

			if (index >= v.size()) {
				index %= v.size();
			}
			if (v.size() == 1) {
				bw.write(v.remove(index) + ">");
			} else {
				bw.write(v.remove(index) + ", ");
			}
		}

		bw.write("\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
