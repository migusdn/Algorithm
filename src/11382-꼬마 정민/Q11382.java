/**
 * @package : Algorithm
 * @name : Q11382
 * @date : 12/28/23 5:34 PM
 * @author : hyunwoopark
 * @version : 1.0.0
 * @modifyed : $
 **/

import java.io.*;

public class Q11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long ans = 0;
        String[] temp = br.readLine().split(" ");
        for(String str: temp){
            ans+=Long.parseLong(str);
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}
