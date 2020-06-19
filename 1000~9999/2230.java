package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        int start = 0, end = 0;
        int mid = 0;
        for (int i = 0; i < N; i++) {
            start = i;
            end = N;

            while (start < end) {
                mid = (start + end) / 2;
                if (arr[mid] - arr[i] < M) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (end == N) {
                continue;
            }

            ans = Math.min(ans, arr[end] - arr[i]);

            if (ans == M) {
                break;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
