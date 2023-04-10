import java.io.*;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            sb.append(Vps(br.readLine().toCharArray())? "YES\n":"NO\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    public static boolean Vps(char[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){

            if(arr[i]=='('){
                j++;
            }
            else if(arr[i]==')'&&j>0) {
                j--;
            }
            else
                return false;
        }
        return j==0;
    }
}
