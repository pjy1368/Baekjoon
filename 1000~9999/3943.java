import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int ans = N;
      while (true) {
        ans = Math.max(ans, N);

        if ((N & (-N)) == N) { // N이 2의 거듭제곱이 될 경우 종료.
          break;
        }

        if (N % 2 == 0) {
          N /= 2;
        } else {
          N = N * 3 + 1;
        }
      }
      sb.append(ans).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}