import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : Main
 * @date : 2/6/24 8:37 PM
 * @modifyed : $
 **/
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arrays = new int[n][];
        int[][] cost = new int[n][];
        for(int i=1; i<=n; i++){
            int[] temp = new int[i];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            arrays[i-1] = temp;
            cost[i-1] = new int[i];
        }
        cost[n-1] = arrays[n-1].clone();
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                cost[i][j] = Math.max(cost[i+1][j], cost[i+1][j+1])+arrays[i][j];
            }
        }
        System.out.println(cost[0][0]);
    }
}
