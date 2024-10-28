import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : solvedac
 * @date : 1/22/24 7:22 PM
 * @modifyed : $
 **/
public class solvedac {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for(int i=0; i<n; i++){
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);
        long exceptCount = Math.round((double)n * 0.15);
        long total = 0;
        for(int i=(int)exceptCount; i<n-exceptCount; i++){
            total+= level[i];
        }
        System.out.println(Math.round(total/(double)(n-exceptCount*2)));


    }
}
