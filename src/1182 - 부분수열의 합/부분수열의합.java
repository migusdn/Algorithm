import java.io.*;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 부분수열의합
 * @date : 4/8/24 7:48 PM
 * @modifyed : $
 **/
public class 부분수열의합 {
    public static int n, s, cnt;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");
        String[] values = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        s = Integer.parseInt(inputs[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        backtracking(0,0);
        if(s==0)
            cnt--;
        System.out.println(cnt);
    }

    public static void backtracking(int idx, int sum) {
        if (idx == n) {
            if (sum == s)
                cnt++;
            return;
        }
        backtracking(idx+1, sum);
        backtracking(idx+1, sum+arr[idx]);
    }

}
