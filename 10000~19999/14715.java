import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int temp = N;
        int cnt = 1;

        // 각 소인수에 해당하는 지수의 합을 구한다.
        while (true) {
            boolean isPrime = true;
            for (int i = 2; i * i <= temp; i++) {
                if (temp % i == 0) {
                    isPrime = false;
                    temp /= i;
                    cnt++;
                    break;
                }
            }

            if (isPrime) {
                break;
            }
        }

        // 완전이진트리의 높이를 구한다.
        int ans = (int) Math.ceil(Math.log10(cnt) / Math.log10(2));
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}