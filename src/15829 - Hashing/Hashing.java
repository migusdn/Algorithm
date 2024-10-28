import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : Hashing
 * @date : 1/22/24 8:14 PM
 * @modifyed : $
 **/
public class Hashing {
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        char[] strArr = br.readLine().toCharArray();
        long sum = 0;
        long pow = 1;
        for (int i = 0; i < l; i++) {
            sum += (strArr[i] - 'a' + 1) * pow % M;
            pow = pow * 31 % M;
        }
        sum = sum%M;
        System.out.println(sum);

    }
}
