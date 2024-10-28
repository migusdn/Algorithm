import java.io.*;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 주유소
 * @date : 2024. 10. 28. 오후 9:53
 * @modifyed : $
 **/
public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n;
        long[] distance;
        long[] cost;


        n = Integer.parseInt(br.readLine());
        distance = new long[n];
        cost = new long[n];

        // parse distance
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        // parse cost
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long currentCost = cost[0];
        long sum = cost[0]*distance[0];
        for(int i=1; i<n; i++){
            if(currentCost <= cost[i]){
                sum += currentCost*distance[i];
            }else{
                currentCost = cost[i];
                sum += currentCost*distance[i];
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
