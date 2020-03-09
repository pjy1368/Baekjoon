import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 여학생
		int M = Integer.parseInt(st.nextToken()); // 남학생
		int K = Integer.parseInt(st.nextToken()); // 인턴에 참가해야하는 학생
		
		int ans = 0;
		
		for(int i = 0; i <= K; i++) {
			int tempN = N - (K - i);
			int tempM = M - i;
			int result = 0;
			
			while(tempN >= 2 && tempM >= 1) {
				tempN -= 2;
				tempM --;
				result++;
			}
			
			ans = Math.max(ans, result);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
