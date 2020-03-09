import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
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
		int K = Integer.parseInt(st.nextToken());
		Vector<Integer> v = new Vector<>();
		input = bf.readLine();
		st = new StringTokenizer(input);
		while (st.hasMoreTokens()) {
			v.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(v);
		bw.write(v.get(K - 1) + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
