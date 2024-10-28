/**
 * @package : Algorithm
 * @name : 벌집
 * @date : 1/22/24 7:41 PM
 * @author : hyunwoopark
 * @version : 1.0.0
 * @modifyed : $
 **/

import java.io.*;

public class 벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 1;
        int i=1;

        while(total<n){
            total += 6 * i;
            i++;
        }
        System.out.println(i);

    }
}
