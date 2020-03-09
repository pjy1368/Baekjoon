import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i = 0; i < 9; i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		
		index++;
		bw.write(max + "\n");
		bw.write(index + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
