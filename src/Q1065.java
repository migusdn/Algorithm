
import java.io.*;
import java.util.StringTokenizer;

public class Q1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int ctn=0;
        for(int i=1; i<=num; i++){
            if(IsSequence(i))
                ctn++;
        }
        bw.write(ctn+"");
        bw.close();
        br.close();
    }
    public static boolean IsSequence(int n){
        char[] num = String.valueOf(n).toCharArray();
        int d;
        if(num.length==1)
            return true;
        else
            d = num[1]-num[0];
        for(int i=0; i<num.length-1; i++){
            if(num[i]+d==num[i+1])
                continue;
            else
                return false;
        }
        return true;
    }
}
