import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q1654 {
    static int n;
    static int[] wire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N개의 랜선을 만들어야 한다
        //K개의 랜선은 길이가 제각각임
        //랜선을 일정한 길이로 N개로 맞춰야한다
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        wire = new int[k];
        for (int i = 0; i < k; i++) {
            wire[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(wire);

        long start = 1;
        long mid = 0;
        long end = wire[k - 1];
        while (end >= start) {
            mid = (start + end) / 2;
            int sum = 0;
            for (int w : wire) {
                sum += w / mid;
            }
            if (sum < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.close();
        br.close();
    }

}