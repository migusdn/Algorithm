import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : IOIOI
 * @date : 2/22/24 11:17 PM
 * @modifyed : $
 **/
public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;
        char[] str = br.readLine().toCharArray();
        int gap = 2 * n + 1;
        for (int i = 0; i <= m - gap; i++) {
            boolean flag = true;
            for (int j = 0; j < gap; j++) {
                if (j % 2 == 0) {
                    if (str[i + j] != 'I') {
                        flag = false;
                        break;
                    }
                } else {
                    if (str[i + j] != 'O') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                answer++;
        }
        System.out.println(answer);
    }
}
