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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			
			String result = "";
			for(int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);
				for(int k = 0; k < N; k++) {
					result += c;
				}
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
