import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[] nums = new int[10001];
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(bf.readLine());
			nums[input]++; // 입력받는 값의 수를 저장함.
		}
		
		for(int i = 1; i <= 10000; i++) { // 1부터 10000까지 저장된 수만큼 출력
			for(int j = 0; j < nums[i]; j++) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
