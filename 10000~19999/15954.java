package no.jam;

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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        double ans = Double.MAX_VALUE;
        double ret = 0;
 
        for (int i = K; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                double m = mean(arr, j, i);
                ret = standardDeviation(arr, m, j, i);
                ans = Math.min(ans, ret);
            }
        }
 
        bw.write(String.format("%.11f", ans)+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 평균을 구하는 함수
    public static double mean(int[] arr, int start, int K) {
        double sum = 0.0;
        for (int i = 0; i < K; i++) {
            sum += arr[start + i];
        }
        return sum / K;
    }
    
    // 표준 편차를 구하는 함수
    public static double standardDeviation(int[] arr, double m, int start, int K) {
        double sum = 0.0;
        for (int i = 0; i < K; i++) {
            sum += Math.pow(arr[start + i] - m, 2);
        }
        return Math.sqrt(sum / K);
    }
 
}