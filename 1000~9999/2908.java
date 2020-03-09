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
		
		StringBuilder sb = new StringBuilder(st.nextToken());
		int n1 = Integer.parseInt(sb.reverse().toString());
		
		sb = new StringBuilder(st.nextToken());
		int n2 = Integer.parseInt(sb.reverse().toString());
		
		bw.write(((n1 > n2) ? n1 : n2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
