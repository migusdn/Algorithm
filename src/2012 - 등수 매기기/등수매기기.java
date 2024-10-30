import java.io.*;
import java.util.Arrays;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 등수매기기
 * @date : 2024. 10. 29. 오후 8:55
 * @modifyed : $
 **/

public class 등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int[] rank;

        n = Integer.parseInt(br.readLine());
        rank = new int[n + 1];
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rank);
        for (int i = 0; i < n + 1; i++) {
            result += Math.abs(i-rank[i]);
        }

        bw.write(String.valueOf(result));
        bw.close();

    }
}
