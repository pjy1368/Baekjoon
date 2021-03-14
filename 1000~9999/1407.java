import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long ans = f(B) - f(A - 1);
    bw.write(ans + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  static long f(long x) {
    long res = x;
    for (long i = 2; i <= x; i <<= 1) {
      res += (x / i) * (i >> 1);
    }
    return res;

  }

}