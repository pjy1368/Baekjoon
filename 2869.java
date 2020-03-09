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
		
		int A = Integer.parseInt(st.nextToken()); // 낮 동안 올라가는 거리
		int B = Integer.parseInt(st.nextToken()); // 밤 동안 미끄러지는 거리
		int V = Integer.parseInt(st.nextToken()); // 도달해야하는 높이
		
		if(A == V) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		double x = (double) (V - A) / (A - B);
		
		int ans = (int) Math.ceil(x) + 1;
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
