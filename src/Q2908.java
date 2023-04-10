import java.io.*;
import java.util.StringTokenizer;

public class Q2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        char[] num1 = st.nextToken().toCharArray();
        char[] num2 = st.nextToken().toCharArray();
        char[] result;
        if(num1[2]<num2[2]) {
            result = num2;
        }
        else if(num1[2]>num2[2])
            result=num1;
        else{
            if(num1[1]<num2[1])
                result=num2;
            else if(num1[1]>num2[1])
                result=num1;
            else{
                if(num1[0]<num2[0])
                    result=num2;
                else
                    result=num1;
            }
        }
        char tmp = result[2];
        result[2] = result[0];
        result[0] = tmp;
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
