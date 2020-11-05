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

        // �� ���μ��� �ش��ϴ� ������ ���� ���Ѵ�.
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

        // ��������Ʈ���� ���̸� ���Ѵ�.
        int ans = (int) Math.ceil(Math.log10(cnt) / Math.log10(2));
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}